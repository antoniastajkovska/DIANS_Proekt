package mk.ukim.finki.dians.mapart.web;

import mk.ukim.finki.dians.mapart.model.Gallery;
import mk.ukim.finki.dians.mapart.service.GalleryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/routes")
public class RoutesController {
    private final GalleryService galleryService;

    // Constructor-based dependency injection
    public RoutesController(GalleryService galleryService) {
        this.galleryService = galleryService;
    }

    // Handles HTTP GET requests for the "/routes" endpoint
    @GetMapping
    public String getRoutesPage(Model model) {
        // Retrieves a list of all galleries
        List<Gallery> galleries = galleryService.listAllGalleries();

        // Adds the list of galleries to the model
        model.addAttribute("galleries", galleries);

        // Returns the logical view name "routes"
        return "routes";
    }
}
