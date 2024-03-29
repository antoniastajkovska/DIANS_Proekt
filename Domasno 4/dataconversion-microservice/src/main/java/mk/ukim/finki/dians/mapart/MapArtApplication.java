package mk.ukim.finki.dians.mapart;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


@SpringBootApplication
@ServletComponentScan
public class MapArtApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MapArtApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {}
}