package com.example.dians_proekt.converter;

import java.io.*;

public class OSMToJsonConverterAndFilter {

    public static void main(String[] args) {
        try {
            filterAndConvert("src/main/resources/files/art.xml", "src/main/resources/files/result.json");
            System.out.println("Conversion completed successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void filterAndConvert(String inputFileName, String outputFileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {

            writer.write("[\n");

            boolean insideNodeOrWay = false;
            String line;
            boolean first_line = true;
            boolean first_bracket = true;
            String lat = "lat";
            String lon = "lon";

            while ((line = reader.readLine()) != null) {

                if ((line.contains("<node") && !line.contains("/>") )|| (line.contains("<way") && !line.contains("/>"))) {
                    String[] node = line.split(" ");
                    for (String s : node) {
                        if(s.contains(lat)) {
                            lat = s.split("=")[1];
                            lat = lat.replace(">", "");
                            lat = lat.replace("<node ", "");
                        }
                        else if(s.contains(lon)) {
                            lon = s.split("=")[1];
                            lon = lon.replace(">", "");
                            lon = lon.replace("<node ", "");
                        }
                    }
                    if(!first_bracket) {
                        writer.write(",");
                    }
                    else {
                        first_bracket = false;
                    }
                    insideNodeOrWay = true;

                    writer.write("\t{\n");
                    if(!lat.equals("lat"))
                        writer.write("\t\t\"lat\" : "+lat+",\n");
                    if(!lon.equals("lon"))
                        writer.write("\t\t\"lon\" : "+lon+",\n");
                    lat = "lat";
                    lon = "lon";
                }

                if (insideNodeOrWay && (line.contains("</node>")||line.contains("</way>"))) {
                    insideNodeOrWay = false;
                    writer.write("\n\t}\n");
                    first_line = true;
                }

                if (insideNodeOrWay && (line.matches("<tag k=\"(name|lat|lon|addr:street|addr:postcode|addr:housenumber|email|phone|opening_hours)\".*"))) {
                    if(!first_line) {
                        writer.write(",\n");
                    }
                    else {
                        first_line = false;
                    }

                    line = line.replaceFirst("<tag k=\"", "\t\t\"");
                    line = line.replaceAll("\" v=\"", "\" : \"");
                    line = line.replaceAll("\"/>", "\"");
                    line = line.replaceAll("\"", "\\\"");

                    writer.write(line );
                }
            }
            writer.write("]\n");
        }
    }
}
