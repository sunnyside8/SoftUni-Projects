package com.example.coffeshopexam.service;

import com.example.coffeshopexam.model.entity.Category;
import com.example.coffeshopexam.model.entity.CategoryEnum;

public interface CategoryService {
    void initCategories();

    Category findByCategoryNameEnum(CategoryEnum categoryEnum);

}
