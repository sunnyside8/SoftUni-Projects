package com.example.shoppinglistexam.service;

import com.example.shoppinglistexam.model.entity.Category;
import com.example.shoppinglistexam.model.entity.CategoryEnum;
import com.example.shoppinglistexam.model.service.ProductServiceModel;
import com.example.shoppinglistexam.model.view.ProductViewModel;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    void add(ProductServiceModel map);

    BigDecimal getTotalSum();

    List<ProductViewModel> findAllProductsByCategory(CategoryEnum categoryEnum);

    void buyById(Long id);

    void buyAll();
}
