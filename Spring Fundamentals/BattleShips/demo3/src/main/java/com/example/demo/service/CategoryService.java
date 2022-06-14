package com.example.demo.service;

import com.example.demo.model.entity.Category;
import com.example.demo.model.entity.CategoryEnum;

public interface CategoryService {
    void initCategories();

    Category getCategory(CategoryEnum category);

}
