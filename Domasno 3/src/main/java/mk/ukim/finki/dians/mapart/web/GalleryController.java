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

    public GalleryController(GalleryService galleryService) {
        this.galleryService = galleryService;
    }

    @GetMapping
    public String getGalleriesPage(Model model,
                                   @RequestParam(required = false) Long id) {
        if(id!=null){
            Gallery gallery=null;
            if(galleryService.findById(id).isPresent()){
                gallery=galleryService.findById(id).get();
                Double lon = gallery.getLon();
                Double lat = gallery.getLat();
                String name = gallery.getName();
                //sets lat and lon
                model.addAttribute("lon",lon);
                model.addAttribute("lan", lat);
                model.addAttribute("name",name);
            }
        }
        List<Gallery> galleries = galleryService.listAllGalleries();
        model.addAttribute("galleries", galleries);
        return "galleries";
    }
    @GetMapping("/setLocation/{id}")
    public String getLocationOfGallery(@PathVariable Long id,
                                       Model model){
        return "redirect:/galleries?id="+id;
    }
}
