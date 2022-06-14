package com.example.demo.model.binding;

import com.example.demo.model.entity.CategoryEnum;
import com.example.demo.model.entity.User;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class ShipAddBindingModel {


    @Size(min = 2,max =10,message = "Name must be between 3 and 10 characters!")
    private String name;

    @Positive
    private Long power;

    @Positive
    private Long health;

    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate created;

    @NotNull
    private CategoryEnum category;



    public ShipAddBindingModel() {
    }

    public String getName() {
        return name;
    }

    public ShipAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public Long getPower() {
        return power;
    }

    public ShipAddBindingModel setPower(Long power) {
        this.power = power;
        return this;
    }

    public Long getHealth() {
        return health;
    }

    public ShipAddBindingModel setHealth(Long health) {
        this.health = health;
        return this;
    }

    public LocalDate getCreated() {
        return created;
    }

    public ShipAddBindingModel setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public ShipAddBindingModel setCategory(CategoryEnum category) {
        this.category = category;
        return this;
    }


}
