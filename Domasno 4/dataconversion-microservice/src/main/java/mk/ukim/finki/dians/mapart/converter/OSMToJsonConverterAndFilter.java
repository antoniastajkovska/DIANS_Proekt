package mk.ukim.finki.dians.mapart.converter;

import mk.ukim.finki.dians.mapart.filters.Pipeline;
import mk.ukim.finki.dians.mapart.filters.RemoveSignFilter;
import mk.ukim.finki.dians.mapart.filters.RemoveTagFilter;
import mk.ukim.finki.dians.mapart.filters.SplitStringFilter;

import java.io.*;

public class OSMToJsonConverterAndFilter {

    public static void main(String[] args) {
        try {
            // Call the filterAndConvert method with input and output file names
            filterAndConvert("src/main/resources/static/data/art.xml", "src/main/resources/static/data/result.json");
            System.out.println("Conversion completed successfully.");
        } catch (IOException e) {
            // Handle IOException if it occurs during file operations
            e.printStackTrace();
        }
    }

    // Method to filter and convert OSM XML data to JSON format
    private static void filterAndConvert(String inputFileName, String outputFileName) throws IOException {
        try (
                // Create BufferedReader for reading from the input XML file
                BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
                // Create BufferedWriter for writing to the output JSON file
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))
        ) {
            // Write the opening bracket of the JSON array
            writer.write("[\n");

            // Variables to track the state and data during processing
            boolean insideNodeOrWay = false;
            String line;
            boolean first_line = true;
            boolean first_bracket = true;
            String lat = "lat";
            String lon = "lon";

            // Read each line from the input XML file
            while ((line = reader.readLine()) != null) {
                // Check if the line contains the start of a node or way element in OSM XML
                if ((line.contains("<node") && !line.contains("/>")) || (line.contains("<way") && !line.contains("/>"))) {
                    // Extract latitude and longitude attributes using a pipeline of filters
                    String[] node = line.split(" ");
                    for (String s : node) {
                        Pipeline<String, String> LatLonPipeline = new Pipeline<>(new SplitStringFilter())
                                .pipe(new RemoveSignFilter())
                                .pipe(new RemoveTagFilter());

                        if (s.contains(lat)) {
                            lat = LatLonPipeline.process(s);
                        } else if (s.contains(lon)) {
                            lon = LatLonPipeline.process(s);
                        }
                    }
                    // Write comma separator if not the first element in the array
                    if (!first_bracket) {
                        writer.write(",");
                    } else {
                        first_bracket = false;
                    }
                    // Set the flag indicating inside a node or way and write JSON object start
                    insideNodeOrWay = true;
                    writer.write("\t{\n");
                    // Write latitude and longitude properties if available
                    if (!lat.equals("lat"))
                        writer.write("\t\t\"lat\" : " + lat + ",\n");
                    if (!lon.equals("lon"))
                        writer.write("\t\t\"lon\" : " + lon + ",\n");
                    lat = "lat";
                    lon = "lon";
                }

                // Check if the line contains the end of a node or way element in OSM XML
                if (insideNodeOrWay && (line.contains("</node>") || line.contains("</way>"))) {
                    // Reset the insideNodeOrWay flag and write JSON object end
                    insideNodeOrWay = false;
                    writer.write("\n\t}\n");
                    first_line = true;
                }
                // Check if the line contains a tag with specific keys in OSM XML
                if (insideNodeOrWay && (line.matches("<tag k=\"(name|lat|lon|addr:street|addr:postcode|addr:housenumber|email|phone|opening_hours)\".*"))) {
                    // Write comma separator if not the first tag in the object
                    if (!first_line) {
                        writer.write(",\n");
                    } else {
                        first_line = false;
                    }
                    // Format and write the tag as a JSON property
                    line = line.replaceFirst("<tag k=\"", "\t\t\"");
                    line = line.replaceAll("\" v=\"", "\" : \"");
                    line = line.replaceAll("\"/>", "\"");
                    line = line.replaceAll("\"", "\\\"");
                    writer.write(line);
                }
            }
            // Write the closing bracket of the JSON array
            writer.write("]\n");
        }
    }
}
