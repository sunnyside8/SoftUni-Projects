package com.example.springdataintroex.service;

import com.example.springdataintroex.model.entity.Category;

import java.io.IOException;
import java.util.Set;

public interface CategoryService {

    void seedCategories() throws IOException;

    Set<Category> getRandomCategories();
}
