package mk.ukim.finki.dians.mapart.repository;

import mk.ukim.finki.dians.mapart.model.Gallery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GalleryRepository extends JpaRepository<Gallery,Long> {
}
