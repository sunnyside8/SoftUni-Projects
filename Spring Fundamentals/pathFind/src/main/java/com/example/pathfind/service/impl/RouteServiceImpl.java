package com.example.pathfind.service.impl;

import com.example.pathfind.model.entity.Route;
import com.example.pathfind.repository.RouteRepository;
import com.example.pathfind.service.RouteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {
    private final RouteRepository routeRepository;

    public RouteServiceImpl(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @Override
    public List<Route> getMostCommented() {
        return routeRepository.findByCommentsSize();
    }
}
