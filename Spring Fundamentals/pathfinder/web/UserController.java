package com.example.pathfinder.web;

import com.example.pathfinder.model.entity.UserRegisterBindingDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid
            UserRegisterBindingDto userRegisterBindingDto){
        //TODO
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
