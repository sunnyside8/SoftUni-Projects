package com.example.shoppinglistexam.repository;

import com.example.shoppinglistexam.model.entity.Category;
import com.example.shoppinglistexam.model.entity.CategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    Optional<Category> getCategoryByName(CategoryEnum name);
}
