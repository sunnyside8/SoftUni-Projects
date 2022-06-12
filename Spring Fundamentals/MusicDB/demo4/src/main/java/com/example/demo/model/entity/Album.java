package com.example.demo.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "albums")
public class Album extends BaseEntity{

    @Column(nullable = false)
    private String name;


    @Column(name = "imag_url")
    private String imgUrl;

    @Column(nullable = false,columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private int copies;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(name = "release_date",nullable = false)
    private LocalDate releaseDate;

    @Column(nullable = false)
    private String producer;

    @Enumerated(EnumType.STRING)
    private GenreEnum genre;

    @OneToOne
    private Artist artist;

    @ManyToOne
    @JoinColumn(name = "added_from_id")
    private User user;

    public Album() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imageUrl) {
        this.imgUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public GenreEnum getGenre() {
        return genre;
    }

    public void setGenre(GenreEnum genre) {
        this.genre = genre;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return copies == album.copies && Objects.equals(name, album.name) && Objects.equals(imgUrl, album.imgUrl) && Objects.equals(description, album.description) && Objects.equals(price, album.price) && Objects.equals(releaseDate, album.releaseDate) && Objects.equals(producer, album.producer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, imgUrl, description, copies, price, releaseDate, producer);
    }
}
