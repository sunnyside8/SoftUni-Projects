package com.example.demo.service;

import com.example.demo.model.entity.Classification;
import com.example.demo.model.entity.ClassificationEnum;

public interface ClassificationService {
    void initClassification();

    Classification getClassification(ClassificationEnum category);

}
