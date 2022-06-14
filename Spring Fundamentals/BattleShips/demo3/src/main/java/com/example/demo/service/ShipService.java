package com.example.demo.service;

import com.example.demo.model.service.ShipServiceModel;
import com.example.demo.model.view.ShipViewModel;

import java.util.List;

public interface ShipService {
    void add(ShipServiceModel map);

    List<ShipViewModel> getShipsOrdered(Long id);

    List<ShipViewModel> getAll();

    void attack(String attacker, String defender);
}
