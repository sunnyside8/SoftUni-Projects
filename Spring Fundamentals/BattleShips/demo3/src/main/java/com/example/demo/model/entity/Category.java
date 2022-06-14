package com.example.demo.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @Column(unique = true)
    private CategoryEnum name;

    @Column(columnDefinition = "TEXT")
    private String description;

    public Category() {
    }

    public CategoryEnum getName() {
        return name;
    }

    public Category setName(CategoryEnum name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Category setDescription(String description) {
        this.description = description;
        return this;
    }
}
