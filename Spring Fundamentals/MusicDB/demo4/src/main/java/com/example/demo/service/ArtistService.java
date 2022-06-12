package com.example.demo.service;

import com.example.demo.model.entity.Artist;
import com.example.demo.model.entity.ArtistEnum;

public interface ArtistService {
    void initCategories();

    Artist getArtist(ArtistEnum category);

}
