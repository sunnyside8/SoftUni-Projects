package com.example.demo.service.Impl;

import com.example.demo.model.entity.User;
import com.example.demo.model.service.UserServiceModel;
import com.example.demo.repository.UserRepository;
import com.example.demo.sec.CurrentUser;
import com.example.demo.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
   private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @Override
    public void registerUser(UserServiceModel userServiceModel) {
        User user = modelMapper.map(userServiceModel,User.class);
        userRepository.save(user);
    }

    @Override
    public UserServiceModel findByEmailAndPassword(String username, String password) {
        return userRepository.findAllByEmailAndPassword(username,password)
                .map(user -> modelMapper.map(user,UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public void loginUser(Long id, String username) {
        currentUser.setId(id);
        currentUser.setEmail(username);
    }

    @Override
    public void logout() {
        currentUser.setId(null);
        currentUser.setEmail(null);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

}
