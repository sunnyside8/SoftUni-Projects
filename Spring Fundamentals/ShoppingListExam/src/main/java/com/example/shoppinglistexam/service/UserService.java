package com.example.shoppinglistexam.service;

import com.example.shoppinglistexam.model.service.UserServiceModel;

public interface UserService {
    boolean registerUser(UserServiceModel map);

    UserServiceModel findByUsernameAndPassword(String username, String password);


}
