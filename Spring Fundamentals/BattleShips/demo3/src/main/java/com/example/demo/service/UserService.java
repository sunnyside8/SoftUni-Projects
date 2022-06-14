package com.example.demo.service;


import com.example.demo.model.entity.User;
import com.example.demo.model.service.UserServiceModel;

public interface UserService {
    void registerUser(UserServiceModel map);

    UserServiceModel findByUsernameAndPassword(String username, String password);


    void login(Long id,String username);

    User getUserById(Long id);

}
