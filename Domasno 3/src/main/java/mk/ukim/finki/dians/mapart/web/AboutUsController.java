package mk.ukim.finki.dians.mapart.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// Indicates that this class is a Spring MVC controller
@Controller
// Maps the controller to a base path
@RequestMapping("/about_us")
public class AboutUsController {

    // Handles HTTP GET requests for the "/about_us" endpoint
    @GetMapping
    public String getAboutUsPage() {
        // Returns the logical view name "aboutUs"
        return "aboutUs";
    }
}
