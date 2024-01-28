package mk.ukim.finki.dians.mapart.service.Impl;

import mk.ukim.finki.dians.mapart.model.Gallery;
import mk.ukim.finki.dians.mapart.repository.GalleryRepository;
import mk.ukim.finki.dians.mapart.service.GalleryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Service implementation for Gallery-related operations
@Service
public class GalleryServiceImpl implements GalleryService {

    // Dependency injection of the GalleryRepository
    private final GalleryRepository galleryRepository;

    // Constructor-based injection to initialize the GalleryRepository
    public GalleryServiceImpl(GalleryRepository galleryRepository) {
        this.galleryRepository = galleryRepository;
    }

    // Implementation of the method to retrieve a list of all galleries
    @Override
    public List<Gallery> listAllGalleries() {
        return galleryRepository.findAll();
    }

    // Implementation of the method to find a gallery by its unique identifier (ID)
    @Override
    public Optional<Gallery> findById(Long id) {
        return galleryRepository.findById(id);
    }

    // Implementation of the method to retrieve a list of galleries by name (partial match)
    @Override
    public List<Gallery> listGalleriesByNameLike(String name) {
        // Check if the provided name is not null and not empty
        if (name != null && !name.isEmpty()) {
            // If a valid name is provided, use the repository method to find galleries by name
            return galleryRepository.findGalleriesByNameContainingIgnoreCase(name);
        } else {
            // If no valid name is provided, return all galleries
            return galleryRepository.findAll();
        }
    }
}
