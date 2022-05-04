package bg.softuni.mobilele.repository;

import bg.softuni.mobilele.model.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
