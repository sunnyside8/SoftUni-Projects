package com.example.demo.service.Impl;

import com.example.demo.model.entity.Classification;
import com.example.demo.model.entity.ClassificationEnum;
import com.example.demo.repository.ClassificationRepository;
import com.example.demo.service.ClassificationService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ClassificationServiceImpl implements ClassificationService {

    private final ClassificationRepository classificationRepository;

    public ClassificationServiceImpl(ClassificationRepository classificationRepository) {
        this.classificationRepository = classificationRepository;
    }


    @Override
    public void initClassification() {
        if(classificationRepository.count()!= 0){
            return;
        }

        Arrays.stream(ClassificationEnum.values())
                .forEach(classificationEnum -> {
                    Classification classification = new Classification();
                    classification.setName(classificationEnum);

                    classificationRepository.save(classification);
                });
    }

    @Override
    public Classification getClassification(ClassificationEnum classification) {
        return classificationRepository.getCategoryByName(classification).orElse(null);

    }
}
