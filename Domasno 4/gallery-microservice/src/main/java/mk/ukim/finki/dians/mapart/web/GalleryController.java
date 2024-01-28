package mk.ukim.finki.dians.mapart.web;

import mk.ukim.finki.dians.mapart.model.Gallery;
import mk.ukim.finki.dians.mapart.service.GalleryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/galleries")
public class GalleryController {

    private final GalleryService galleryService;

    // Constructor-based dependency injection
    public GalleryController(GalleryService galleryService) {
        this.galleryService = galleryService;
    }

    // Handles HTTP GET requests for the "/galleries" endpoint
    @GetMapping
    public String getGalleriesPage(Model model) {

        // List all galleries
        List<Gallery> galleries = galleryService.listAllGalleries();
        model.addAttribute("galleries", galleries);

        // Return the logical view name "galleries"
        return "galleries";
    }

    // Handles HTTP POST requests for the "/galleries" endpoint
    @PostMapping
    public String searchGalleriesByName(Model model,
                                        @RequestParam(required = false) String galleryName) {

        // If 'galleryName' parameter is provided, perform a search by name.Otherwise, list all galleries
        List<Gallery> galleries = galleryService.listGalleriesByNameLike(galleryName);
        model.addAttribute("galleries", galleries);

        // Return the logical view name "galleries"
        return "galleries";
    }
}
