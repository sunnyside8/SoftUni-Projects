package com.example.shoppinglistexam.service;

import com.example.shoppinglistexam.model.entity.Category;
import com.example.shoppinglistexam.model.entity.CategoryEnum;

public interface CategoryService {
    void initCategories();

    Category getCategory(CategoryEnum category);

}
