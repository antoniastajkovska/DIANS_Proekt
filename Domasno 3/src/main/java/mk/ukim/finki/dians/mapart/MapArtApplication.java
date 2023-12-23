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
       ObjectMapper objectMapper = new ObjectMapper();
       File jsonFile = new File("src\\main\\java\\mk\\ukim\\finki\\dians\\mapart\\data\\result.json").getAbsoluteFile();
       List<Gallery> galleries = Arrays.asList(objectMapper.readValue(jsonFile,Gallery[].class));
       galleryRepository.saveAll(galleries);
    }
}
