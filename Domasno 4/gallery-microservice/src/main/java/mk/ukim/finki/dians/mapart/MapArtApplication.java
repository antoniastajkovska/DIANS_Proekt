package mk.ukim.finki.dians.mapart;

import com.fasterxml.jackson.databind.ObjectMapper;
import mk.ukim.finki.dians.mapart.model.Gallery;
import mk.ukim.finki.dians.mapart.repository.GalleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@ServletComponentScan
public class MapArtApplication implements CommandLineRunner {

    @Autowired
    private GalleryRepository galleryRepository;

    public static void main(String[] args) throws IOException, InterruptedException {
        SpringApplication.run(MapArtApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // get json from http://localhost:9091/data
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:9091/data"))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());  // Print the response body
        String jsonString = response.body();

        // Create an ObjectMapper to map JSON to Java objects
        ObjectMapper objectMapper = new ObjectMapper();

        // Read the JSON string and map it to a list of Gallery objects
        List<Gallery> galleries = Arrays.asList(objectMapper.readValue(jsonString, Gallery[].class));
        // print galleries
        for (Gallery gallery : galleries) {
            System.out.println(gallery);
        }

        // Save the list of galleries to the database using the injected GalleryRepository
        galleryRepository.saveAll(galleries);
    }
}