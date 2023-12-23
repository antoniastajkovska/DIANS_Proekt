package mk.ukim.finki.dians.mapart.service.Impl;

import mk.ukim.finki.dians.mapart.model.Gallery;
import mk.ukim.finki.dians.mapart.repository.GalleryRepository;
import mk.ukim.finki.dians.mapart.service.GalleryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GalleryServiceImpl implements GalleryService {
    private final GalleryRepository galleryRepository;

    public GalleryServiceImpl(GalleryRepository galleryRepository) {
        this.galleryRepository = galleryRepository;
    }

    @Override
    public List<Gallery> listAllGalleries() {
        return galleryRepository.findAll();
    }

    @Override
    public Optional<Gallery> findById(Long id) {
        return galleryRepository.findById(id);
    }
}
