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
    public String getGalleriesPage(Model model,
                                   @RequestParam(required = false) Long id,
                                   @RequestParam(required = false) String galleryName) {
        // If an 'id' parameter is provided, fetch the details of a specific gallery
        if (id != null) {
            Gallery gallery = null;
            if (galleryService.findById(id).isPresent()) {
                gallery = galleryService.findById(id).get();
                Double lon = gallery.getLon();
                Double lat = gallery.getLat();
                String name = gallery.getName();
                // Set latitude, longitude, and name attributes for Thymeleaf template
                model.addAttribute("lon", lon);
                model.addAttribute("lat", lat);
                model.addAttribute("name", name);
            }
        }
        // If 'galleryName' parameter is provided, perform a search by name
        if (galleryName != null && !galleryName.isEmpty()) {
            List<Gallery> galleries = galleryService.listGalleriesByNameLike(galleryName);
            model.addAttribute("galleries", galleries);
        } else {
            // Otherwise, list all galleries
            List<Gallery> galleries = galleryService.listAllGalleries();
            model.addAttribute("galleries", galleries);
        }
        // Return the logical view name "galleries"
        return "galleries";
    }

    // Handles HTTP GET requests for the "/galleries/setLocation/{id}" endpoint
    @GetMapping("/setLocation/{id}")
    public String getLocationOfGallery(@PathVariable Long id,
                                       Model model) {
        // Redirect to the "/galleries" endpoint with the gallery's ID as a parameter
        return "redirect:/galleries?id=" + id;
    }

    // Handles HTTP POST requests for the "/galleries" endpoint
    @PostMapping
    public String searchGalleriesByName(Model model,
                                        @RequestParam(required = false) Long id,
                                        @RequestParam(required = false) String galleryName) {
        // If 'galleryName' parameter is provided, perform a search by name
        if (galleryName != null && !galleryName.isEmpty()) {
            List<Gallery> galleries = galleryService.listGalleriesByNameLike(galleryName);
            model.addAttribute("galleries", galleries);
        } else {
            // Otherwise, list all galleries
            List<Gallery> galleries = galleryService.listAllGalleries();
            model.addAttribute("galleries", galleries);
        }
        // Return the logical view name "galleries"
        return "galleries";
    }
}