package com.example.demo.model.view;

import com.example.demo.model.entity.ClassificationEnum;
import com.example.demo.model.entity.ProgressEnum;

import java.time.LocalDate;

public class TaskViewModel {

    private Long id;
    private String name;
    private String assignedTo;
    private ClassificationEnum classification;
    private LocalDate dueDate;
    private ProgressEnum progress;

    public Long getId() {
        return id;
    }

    public TaskViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public TaskViewModel setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
        return this;
    }

    public ClassificationEnum getClassification() {
        return classification;
    }

    public TaskViewModel setClassification(ClassificationEnum classification) {
        this.classification = classification;
        return this;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public TaskViewModel setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public ProgressEnum getProgress() {
        return progress;
    }

    public TaskViewModel setProgress(ProgressEnum progress) {
        this.progress = progress;
        return this;
    }

    public String getName() {
        return name;
    }

    public TaskViewModel setName(String name) {
        this.name = name;
        return this;
    }
}
