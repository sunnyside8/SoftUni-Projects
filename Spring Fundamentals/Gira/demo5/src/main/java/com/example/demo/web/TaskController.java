package com.example.demo.web;

import com.example.demo.model.binding.TaskBindingModel;
import com.example.demo.model.service.TaskServiceModel;
import com.example.demo.sec.CurrentUser;
import com.example.demo.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@RequestMapping("/tasks")
@Controller
public class TaskController {

    private final CurrentUser currentUser;
    private final TaskService taskService;
    private final ModelMapper modelMapper;

    public TaskController(CurrentUser currentUser, TaskService taskService, ModelMapper modelMapper) {
        this.currentUser = currentUser;

        this.taskService = taskService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/add")
    public String add() {
        if (currentUser.getId() == null) {
            return "redirect:/login";
        }
        return "add-task";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid TaskBindingModel taskBindingModel,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("taskBindingModel", taskBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.taskBindingModel", bindingResult);

            return "redirect:add";
        }

        taskService.addTask(modelMapper.map(taskBindingModel, TaskServiceModel.class));
        return "redirect:/";
    }

    @GetMapping("/setProgress/{id}")
    public String setProgress(@PathVariable Long id){
        taskService.changeProgressOfTaskOrDeleteIt(id);
        return "redirect:/";

    }


    @ModelAttribute
    public TaskBindingModel taskBindingModel() {
        return new TaskBindingModel();
    }
}
