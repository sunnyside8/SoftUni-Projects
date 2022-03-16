package com.example.springmappingobjectsex.models.dtos;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

public class GameAddDto {
    @Pattern(regexp = "[A-Z][a-z]{6,100}",message = "Enter valid title")
    private String title;

    @DecimalMin(value = "0",message = "Enter valid price")
    private BigDecimal price;

    @Min(0)
    private Double size;

    @Size(min = 11,max = 11,message = "Enter valid trailer")
    private String trailer;

    @Pattern(regexp = "(https?).+",message = "Enter valid URL")
    private String thumbnailURL;

    @Size(min = 20,message = "Enter valid description")
    private String description;

    private LocalDate releaseDate;

    public GameAddDto() {
    }

    public GameAddDto(String title, BigDecimal price, Double size, String trailer, String thumbnailURL, String description, LocalDate releaseDate) {
        this.title = title;
        this.price = price;
        this.size = size;
        this.trailer = trailer;
        this.thumbnailURL = thumbnailURL;
        this.description = description;
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public void setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
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
}
