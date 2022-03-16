package com.example.springmappingobjectsex.services;

import com.example.springmappingobjectsex.models.dtos.UserLoginDto;
import com.example.springmappingobjectsex.models.dtos.UserRegisterDto;
import com.example.springmappingobjectsex.models.entities.User;

public interface UserService {
    void registerUser(UserRegisterDto userRegisterDto);

    void loginUser(UserLoginDto userLoginDto);

    void logout();

    boolean isLoggedUserAdmin();

    User getLoggedInUser();

    void printOwnedGames();
}
