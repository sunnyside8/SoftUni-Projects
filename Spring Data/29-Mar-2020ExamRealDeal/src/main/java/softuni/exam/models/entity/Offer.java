package softuni.exam.models.entity;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "offers")
public class Offer extends BaseEntity{

    @Positive
    private BigDecimal price;

    @Column(columnDefinition = "TEXT")
    @Size(min = 5)
    private String description;

    @Column(name = "has_gold_status")
    private boolean hasGoldStatus;

    @Column(name = "added_on")
    private LocalDateTime addedOn;

    @ManyToOne
    private Car car;

    @ManyToOne
    private Seller seller;

    @ManyToMany
    private Set<Picture> pictures;

    public Offer() {
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isHasGoldStatus() {
        return hasGoldStatus;
    }

    public void setHasGoldStatus(boolean hasGoldStatus) {
        this.hasGoldStatus = hasGoldStatus;
    }

    public LocalDateTime getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(LocalDateTime addedOn) {
        this.addedOn = addedOn;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Set<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
    }
}
