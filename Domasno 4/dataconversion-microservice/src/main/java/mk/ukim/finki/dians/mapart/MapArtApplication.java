package mk.ukim.finki.dians.mapart;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import java.io.File;


@SpringBootApplication
@ServletComponentScan
public class MapArtApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MapArtApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Create an ObjectMapper to map JSON to Java objects
        ObjectMapper objectMapper = new ObjectMapper();

        // Specify the path to the JSON file
        File jsonFile = new File("src/main/resources/static/data/result.json").getAbsoluteFile();

    }
}