package bg.softuni.mobilele.model.entity;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "offers")
public class Offer extends BaseEntity{

    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Engine engine;

    private String imageUrl;

    @Column(nullable = false)
    private Integer mileage;

    private BigInteger price;

    private Integer year;

    @Enumerated
    private Transmission transmission;

    @ManyToOne
    private Model model;

    @ManyToOne
    private User user;

    public Offer() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
