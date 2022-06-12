package com.example.demo.service.Impl;

import com.example.demo.model.entity.Album;
import com.example.demo.model.service.AlbumServiceModel;
import com.example.demo.model.view.AlbumViewModel;
import com.example.demo.repository.AlbumRepository;
import com.example.demo.sec.CurrentUser;
import com.example.demo.service.AlbumService;
import com.example.demo.service.ArtistService;
import com.example.demo.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;
    private final ModelMapper modelMapper;
    private final ArtistService artistService;
    private final UserService userService;
    private final CurrentUser currentUser;

    public AlbumServiceImpl(AlbumRepository albumRepository, ModelMapper modelMapper, ArtistService artistService, UserService userService, CurrentUser currentUser) {
        this.albumRepository = albumRepository;
        this.modelMapper = modelMapper;
        this.artistService = artistService;
        this.userService = userService;
        this.currentUser = currentUser;
    }


    @Override
    public void add(AlbumServiceModel albumServiceModel) {
        Album album = modelMapper.map(albumServiceModel,Album.class);
        album.setArtist(artistService.getArtist(albumServiceModel.getArtist()));
        album.setUser(userService.getUserById(currentUser.getId()));
        albumRepository.save(album);
    }

    @Override
    public List<AlbumViewModel> getAllAlbumsSortedByCopiesDesc() {
        return albumRepository.getByOrderByCopiesDesc()
                .stream().map(album -> {
                    AlbumViewModel albumViewModel = modelMapper.map(album,AlbumViewModel.class);
                    albumViewModel.setArtist(album.getArtist().getName());
                    return albumViewModel;
                })
                .collect(Collectors.toList());

    }

    @Override
    public int getTotalCopies() {
        return albumRepository.totalCopies();
    }

    @Override
    public void buyById(Long id) {
        albumRepository.deleteById(id);
    }
}
