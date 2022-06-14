package com.example.demo.model.service;

import com.example.demo.model.entity.CategoryEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

public class ShipServiceModel {
    private Long id;
    private String name;
    private Long power;
    private Long health;
    private LocalDate created;
    private CategoryEnum category;

    public ShipServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public ShipServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ShipServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public Long getPower() {
        return power;
    }

    public ShipServiceModel setPower(Long power) {
        this.power = power;
        return this;
    }

    public Long getHealth() {
        return health;
    }

    public ShipServiceModel setHealth(Long health) {
        this.health = health;
        return this;
    }

    public LocalDate getCreated() {
        return created;
    }

    public ShipServiceModel setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public ShipServiceModel setCategory(CategoryEnum category) {
        this.category = category;
        return this;
    }
}
