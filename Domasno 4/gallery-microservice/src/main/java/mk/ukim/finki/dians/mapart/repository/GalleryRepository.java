package mk.ukim.finki.dians.mapart.repository;

import mk.ukim.finki.dians.mapart.model.Gallery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// Spring stereotype annotation indicating that the class is a repository
@Repository
// Interface extending JpaRepository for basic CRUD operations on the Gallery entity
public interface GalleryRepository extends JpaRepository<Gallery, Long> {

    // Custom query method to find galleries by name, ignoring case
    List<Gallery> findGalleriesByNameContainingIgnoreCase(String name);
}