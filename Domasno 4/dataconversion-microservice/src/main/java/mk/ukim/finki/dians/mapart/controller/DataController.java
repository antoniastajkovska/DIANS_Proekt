package mk.ukim.finki.dians.mapart.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
public class DataController {
    @GetMapping("/data")
    public String getData() throws IOException {
        String json = new String(Files.readAllBytes(Paths.get("C:\\Users\\Korisnik\\OneDrive - UKIM, FINKI\\Desktop\\Domasno 4\\dataconversion-microservice\\src\\main\\resources\\static\\data\\result.json")));
        System.out.println(json);
        return json;
    }
}
