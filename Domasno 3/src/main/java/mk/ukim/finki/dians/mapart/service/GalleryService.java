package mk.ukim.finki.dians.mapart.service;

import mk.ukim.finki.dians.mapart.model.Gallery;
import mk.ukim.finki.dians.mapart.repository.GalleryRepository;

import java.util.List;
import java.util.Optional;

public interface GalleryService {
    List<Gallery> listAllGalleries();
    Optional<Gallery> findById(Long id);
    List<Gallery> listGalleriesByNameLike(String name);
}
