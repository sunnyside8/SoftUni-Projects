package com.example.shoppinglistexam.repository;

import com.example.shoppinglistexam.model.entity.CategoryEnum;
import com.example.shoppinglistexam.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query("SELECT SUM(p.price) FROM Product p")
    BigDecimal getTotalProductsPrice();

    List<Product> findByCategory_Name(CategoryEnum category_name);
}
