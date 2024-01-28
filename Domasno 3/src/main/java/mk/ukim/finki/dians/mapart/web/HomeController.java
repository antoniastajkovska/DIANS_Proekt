package mk.ukim.finki.dians.mapart.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Controller
@RequestMapping("/home")
public class HomeController {

    // Handles HTTP GET requests for the "/home" endpoint
    @GetMapping
    public String getHomePage() throws IOException, InterruptedException {
        System.out.println("ok");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:9090/data"))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Printing responce.body");
        System.out.println(response.body());  // Print the response body
        // Returns the logical view name "home"
        return "home";
    }
}