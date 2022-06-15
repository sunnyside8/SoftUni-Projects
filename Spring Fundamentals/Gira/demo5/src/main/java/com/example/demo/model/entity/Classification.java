package com.example.demo.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "classifications")
public class Classification extends BaseEntity{

    @Enumerated(EnumType.STRING)
    private ClassificationEnum name;

    @Column(columnDefinition = "TEXT")
    private String description;

    public Classification() {
    }

    public ClassificationEnum getName() {
        return name;
    }

    public void setName(ClassificationEnum name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public Classification setDescription(String description) {
        this.description = description;
        return this;
    }
}
