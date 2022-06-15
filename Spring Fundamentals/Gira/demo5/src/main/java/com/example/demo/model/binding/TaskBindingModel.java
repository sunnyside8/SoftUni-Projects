package com.example.demo.model.binding;

import com.example.demo.model.entity.ClassificationEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class TaskBindingModel {

    @NotNull(message = "Cannot be blank")
    @Size(min = 3,max = 20,message = "Must be between 3 and 20")
    private String name;

    @NotNull(message = "Cannot be blank")
    @Size(min = 5,message = "The minimum is 5 characters")
    private String description;

    @FutureOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate;

    @NotNull(message = "Cannot be blank")
    private ClassificationEnum classification;

    public TaskBindingModel() {
    }

    public String getName() {
        return name;
    }

    public TaskBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TaskBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public TaskBindingModel setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public ClassificationEnum getClassification() {
        return classification;
    }

    public TaskBindingModel setClassification(ClassificationEnum classification) {
        this.classification = classification;
        return this;
    }
}
