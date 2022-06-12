package com.example.demo.service;

import com.example.demo.model.service.AlbumServiceModel;
import com.example.demo.model.view.AlbumViewModel;

import java.util.List;

public interface AlbumService {
    void add(AlbumServiceModel map);

    List<AlbumViewModel> getAllAlbumsSortedByCopiesDesc();

    int getTotalCopies();

    void buyById(Long id);

}
