package bg.softuni.mobilele.model.entity;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "brands")
public class Brand extends BaseEntity{

    private String name;

    @OneToMany(mappedBy = "brand",cascade = CascadeType.ALL)
    private List<Model> models;


    public Brand() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Model> getModels() {
        return models;
    }

    public void setModels(List<Model> models) {
        this.models = models;
    }


}
