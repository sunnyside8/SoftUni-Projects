package com.example.coffeshopexam.service;

import com.example.coffeshopexam.model.entity.User;
import com.example.coffeshopexam.model.service.UserServiceModel;
import com.example.coffeshopexam.model.view.UserViewModel;

import java.util.List;

public interface UserService {
    void registerUser(UserServiceModel map);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    User findById(Long id);

    List<UserViewModel> findAllUsersAndCountOfOrdersDesc();
}
