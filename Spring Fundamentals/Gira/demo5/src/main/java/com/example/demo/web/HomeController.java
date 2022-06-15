package com.example.demo.web;


import com.example.demo.sec.CurrentUser;
import com.example.demo.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final TaskService taskService;
    private final CurrentUser currentUser;

    public HomeController(TaskService taskService, CurrentUser currentUser) {
        this.taskService = taskService;
        this.currentUser = currentUser;
    }


    @GetMapping("/")
    public String index(Model model){
       if (currentUser.getId() == null) {
           return "index";
       }
       model.addAttribute("tasks",taskService.getAllTasks());

     return "home";
    }
}
