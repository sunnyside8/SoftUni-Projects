package com.example.demo.repository;


import com.example.demo.model.entity.Classification;
import com.example.demo.model.entity.ClassificationEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClassificationRepository extends JpaRepository<Classification,Long> {

    Optional<Classification> getCategoryByName(ClassificationEnum name);
}
