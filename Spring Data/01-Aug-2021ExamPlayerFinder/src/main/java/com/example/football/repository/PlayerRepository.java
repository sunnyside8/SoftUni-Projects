package com.example.football.repository;

import com.example.football.models.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Long> {


    @Query("SELECT p FROM Player p WHERE p.birthDate BETWEEN :low AND :high " +
            "ORDER BY p.stat.shooting DESC , p.stat.passing DESC,p.stat.endurance DESC, p.lastName")
    List<Player> findAllByBirthDateBetweenOrderByStatDescLastName(LocalDate low, LocalDate high);
}
