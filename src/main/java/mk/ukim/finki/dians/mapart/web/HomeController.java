package mk.ukim.finki.dians.mapart.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    // Handles HTTP GET requests for the "/home" endpoint
    @GetMapping
    public String getHomePage() {
        // Returns the logical view name "home"
        return "home";
    }
}