package com.example.demo.service.impl;

import com.example.demo.model.entity.Ship;
import com.example.demo.model.service.ShipServiceModel;
import com.example.demo.model.view.ShipViewModel;
import com.example.demo.repository.ShipRepository;
import com.example.demo.sec.CurrentUser;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ShipService;
import com.example.demo.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShipServiceImpl implements ShipService {

    private final ShipRepository shipRepository;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;
    private final UserService userService;
    private final CurrentUser currentUser;

    public ShipServiceImpl(ShipRepository shipRepository, ModelMapper modelMapper, CategoryService categoryService, HttpSession httpSession, UserService userService, CurrentUser currentUser) {
        this.shipRepository = shipRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
        this.currentUser = currentUser;
        this.userService = userService;
    }

    @Override
    public void add(ShipServiceModel shipServiceModel) {
        Ship ship = modelMapper.map(shipServiceModel, Ship.class);
        ship.setCategory(categoryService.getCategory(shipServiceModel.getCategory()));
        ship.setUser(userService.getUserById(currentUser.getId()));
        shipRepository.save(ship);
    }

    @Override
    public List<ShipViewModel> getShipsOrdered(Long id) {
        return shipRepository.getByUser_Id(id).stream()
                .map(ship -> modelMapper.map(ship,ShipViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ShipViewModel> getAll() {
        return shipRepository.getByOrderByNameAscHealthAscPowerAsc().stream()
                .map(ship -> modelMapper.map(ship,ShipViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void attack(String attacker, String defender) {
        Ship attackerEntity = shipRepository.getByName(attacker);
        Ship defenderEntity = shipRepository.getByName(defender);

        long defenderHealth = defenderEntity.getHealth() - attackerEntity.getPower();
        if(defenderHealth <= 0){
            shipRepository.delete(defenderEntity);
            return;
        }
        defenderEntity.setHealth(defenderHealth);
        shipRepository.save(defenderEntity);
    }
}
