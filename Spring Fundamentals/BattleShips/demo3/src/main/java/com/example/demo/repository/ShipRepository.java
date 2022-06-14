package com.example.demo.repository;

import com.example.demo.model.entity.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipRepository extends JpaRepository<Ship,Long> {

    List<Ship> getByUser_Id(Long user_id);

    List<Ship> getByOrderByNameAscHealthAscPowerAsc();

    Ship getByName(String name);
}
