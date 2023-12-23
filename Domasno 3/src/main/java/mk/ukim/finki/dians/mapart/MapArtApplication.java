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
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@ServletComponentScan
public class MapArtApplication implements CommandLineRunner {

    @Autowired
    private GalleryRepository galleryRepository;

    public static void main(String[] args) {
        SpringApplication.run(MapArtApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Create an ObjectMapper to map JSON to Java objects
        ObjectMapper objectMapper = new ObjectMapper();

        // Specify the path to the JSON file
        File jsonFile = new File("src/main/resources/static/data/result.json").getAbsoluteFile();

        // Read the JSON file and map it to a list of Gallery objects
        List<Gallery> galleries = Arrays.asList(objectMapper.readValue(jsonFile, Gallery[].class));

        // Save the list of galleries to the database using the injected GalleryRepository
        galleryRepository.saveAll(galleries);
    }
}