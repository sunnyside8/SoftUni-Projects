package com.example.demo.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "artists")
public class Artist extends BaseEntity{

    @Enumerated(EnumType.STRING)
    private ArtistEnum name;

    @Column(columnDefinition = "TEXT",name = "career_information")
    private String careerInformation;

    public Artist() {
    }

    public ArtistEnum getName() {
        return name;
    }

    public Artist setName(ArtistEnum name) {
        this.name = name;
        return this;
    }

    public String getCareerInformation() {
        return careerInformation;
    }

    public void setCareerInformation(String careerInformation) {
        this.careerInformation = careerInformation;
    }
}
