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

    public RoutesController(GalleryService galleryService) {
        this.galleryService = galleryService;
    }

    @GetMapping
    public String getRoutesPage(Model model){
        List<Gallery> galleries = galleryService.listAllGalleries();
        model.addAttribute("galleries",galleries);
        return "routes";
    }
}
