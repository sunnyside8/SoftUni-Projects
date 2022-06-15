package com.example.demo.service;


import com.example.demo.model.entity.User;
import com.example.demo.model.service.UserServiceModel;

public interface UserService {
    void registerUser(UserServiceModel map);

    UserServiceModel findByEmailAndPassword(String username, String password);

    void loginUser(Long id, String username);

    void logout();

    User findByEmail(String email);

}
