package mk.ukim.finki.dians.mapart.service;

import mk.ukim.finki.dians.mapart.model.Gallery;

import java.util.List;
import java.util.Optional;

// Interface defining the contract for Gallery-related services
public interface GalleryService {

    // Method to retrieve a list of all galleries
    List<Gallery> listAllGalleries();

    // Method to find a gallery by its unique identifier (ID)
    Optional<Gallery> findById(Long id);

    // Method to retrieve a list of galleries by name (partial match)
    List<Gallery> listGalleriesByNameLike(String name);
}