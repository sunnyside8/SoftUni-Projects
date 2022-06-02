package com.example.pathfind.repository;

import com.example.pathfind.model.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<Route,Long> {

    @Query("SELECT r FROM Route r ORDER BY size(r.comments) DESC")
    List<Route> findByCommentsSize();
}
