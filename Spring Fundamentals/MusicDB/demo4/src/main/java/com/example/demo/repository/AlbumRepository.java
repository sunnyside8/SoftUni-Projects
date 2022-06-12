package com.example.demo.repository;

import com.example.demo.model.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album,Long> {


        List<Album> getByOrderByCopiesDesc();

        @Query("SELECT SUM(a.copies) FROM Album a")
        int totalCopies();
}
