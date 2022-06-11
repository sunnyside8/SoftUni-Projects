package com.example.shoppinglistexam.service.impl;

import com.example.shoppinglistexam.model.entity.User;
import com.example.shoppinglistexam.model.service.UserServiceModel;
import com.example.shoppinglistexam.repository.UserRepository;
import com.example.shoppinglistexam.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean registerUser(UserServiceModel userServiceModel) {
        try{
            userRepository.save( modelMapper.map(userServiceModel,User.class));
        } catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username,password)
                .map(user -> modelMapper.map(user,UserServiceModel.class))
                .orElse(null);
    }

}
