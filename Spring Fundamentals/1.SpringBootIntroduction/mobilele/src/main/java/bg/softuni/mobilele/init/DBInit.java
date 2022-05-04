package bg.softuni.mobilele.init;

import bg.softuni.mobilele.model.entity.Brand;
import bg.softuni.mobilele.model.entity.Category;
import bg.softuni.mobilele.model.entity.Model;
import bg.softuni.mobilele.repository.BrandRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class DBInit implements CommandLineRunner {

    private final BrandRepository brandRepository;

    public DBInit(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public void run(String... args){
        if(brandRepository.count() == 0){
            Brand ford = new Brand();
            ford.setName("Ford");

            Model fiest = new Model();
            fiest.setName("Fiesta");
            fiest.setImageUrl("https://dizzyriders.bg/uploads/thumbs/gallery/2021-09/f2084ac78384b4fa33e6f8eb84908bb1-620x427.jpg");
            fiest.setStartYear(1976);
            fiest.setCategory(Category.CAR);

            Model escort = new Model();
            escort.setName("Escort");
            escort.setImageUrl("https://www.auto-data.net/images/f48/Ford-Escort-VI-Hatch-GAL.jpg");
            escort.setStartYear(1968);
            escort.setEndYear(2002);
            escort.setCategory(Category.CAR);

            ford.setModels(List.of(fiest,escort));
            fiest.setBrand(ford);
            escort.setBrand(ford);

            brandRepository.save(ford);

        }
    }
}
