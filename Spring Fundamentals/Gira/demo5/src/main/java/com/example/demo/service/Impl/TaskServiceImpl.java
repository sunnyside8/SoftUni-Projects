package com.example.demo.service.Impl;

import com.example.demo.model.entity.ProgressEnum;
import com.example.demo.model.entity.Task;
import com.example.demo.model.service.TaskServiceModel;
import com.example.demo.model.view.TaskViewModel;
import com.example.demo.repository.TaskRepository;
import com.example.demo.sec.CurrentUser;
import com.example.demo.service.ClassificationService;
import com.example.demo.service.TaskService;
import com.example.demo.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final CurrentUser currentUser;
    private final ClassificationService classificationService;
    private final ModelMapper modelMapper;
    private final UserService userService;

    public TaskServiceImpl(TaskRepository taskRepository, CurrentUser currentUser, ClassificationService classificationService, ModelMapper modelMapper, UserService userService) {
        this.taskRepository = taskRepository;
        this.currentUser = currentUser;
        this.classificationService = classificationService;
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @Override
    public void addTask(TaskServiceModel taskServiceModel) {
        Task task = modelMapper.map(taskServiceModel, Task.class);
        task.setClassification(classificationService.getClassification(taskServiceModel.getClassification()));
        task.setUser(userService.findByEmail(currentUser.getEmail()));
        task.setProgress(ProgressEnum.OPEN);
        taskRepository.save(task);
    }

    @Override
    public List<TaskViewModel> getAllTasks() {
        return taskRepository.getAllBy().stream()
                .map(task -> {
                    TaskViewModel taskViewModel = modelMapper.map(task, TaskViewModel.class);
                    taskViewModel.setAssignedTo(task.getUser().getUsername());
                    taskViewModel.setClassification(task.getClassification().getName());
                    taskViewModel.setProgress(task.getProgress());
                    return taskViewModel;
                }).collect(Collectors.toList());
    }

    @Override
    public void changeProgressOfTaskOrDeleteIt(Long id) {
        Task task = taskRepository.findTaskById(id);
        String taskProgress = task.getProgress().name();
        switch (taskProgress) {
            case "OPEN":
                task.setProgress(ProgressEnum.IN_PROGRESS);
                taskRepository.save(task);
                break;
            case "IN_PROGRESS":
                task.setProgress(ProgressEnum.COMPLETED);
                taskRepository.save(task);
                break;
            case "COMPLETED":
                taskRepository.delete(task);
                break;
        }
    }
}
