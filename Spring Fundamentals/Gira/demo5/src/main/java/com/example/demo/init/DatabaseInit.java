package com.example.demo.init;


import com.example.demo.service.ClassificationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInit implements CommandLineRunner {

    private final ClassificationService categoryService;

    public DatabaseInit(ClassificationService categoryService) {
        this.categoryService = categoryService;
    }


    @Override
    public void run(String... args) throws Exception {
        categoryService.initClassification();
    }
}
