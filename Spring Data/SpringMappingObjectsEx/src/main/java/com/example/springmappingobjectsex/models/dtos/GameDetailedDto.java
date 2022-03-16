package com.example.springmappingobjectsex.models.dtos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GameDetailedDto extends GameInfoDto{
    private String description;
    private LocalDate releaseDate;

    public GameDetailedDto() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return String.format("Title: %s\n" +
                "Price: %.2f \n" +
                "Description: %s \n" +
                "Release date: %s\n",super.getTitle(),super.getPrice(),this.description,releaseDate.format(DateTimeFormatter.ofPattern("dd-MM-yy")));
    }
}
