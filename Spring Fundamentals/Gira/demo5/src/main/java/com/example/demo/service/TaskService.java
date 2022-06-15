package com.example.demo.service;

import com.example.demo.model.service.TaskServiceModel;
import com.example.demo.model.view.TaskViewModel;

import java.util.List;

public interface TaskService {
    void addTask(TaskServiceModel taskServiceModel);

    List<TaskViewModel> getAllTasks();

    void changeProgressOfTaskOrDeleteIt(Long id);

}
