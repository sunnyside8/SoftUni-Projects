package com.example.demo.service.impl;

import com.example.demo.model.entity.Category;
import com.example.demo.model.entity.CategoryEnum;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public void initCategories() {
        if(categoryRepository.count()!= 0){
            return;
        }

        Arrays.stream(CategoryEnum.values())
                .forEach(categoryEnum -> {
                    Category category = new Category();
                    category.setName(categoryEnum);

                    categoryRepository.save(category);
                });
    }

    @Override
    public Category getCategory(CategoryEnum category) {
        return categoryRepository.getCategoryByName(category).orElse(null);
    }
}
