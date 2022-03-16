package com.example.springmappingobjectsex.services.impls;

import com.example.springmappingobjectsex.models.dtos.UserGamesDto;
import com.example.springmappingobjectsex.models.dtos.UserLoginDto;
import com.example.springmappingobjectsex.models.dtos.UserRegisterDto;
import com.example.springmappingobjectsex.models.entities.User;
import com.example.springmappingobjectsex.repositories.UserRepository;
import com.example.springmappingobjectsex.services.UserService;
import com.example.springmappingobjectsex.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private User loggedInUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.loggedInUser = null;
    }


    @Override
    public void registerUser(UserRegisterDto userRegisterDto) {

        if(!userRegisterDto.getPassword().equals(userRegisterDto.getConfirmPassword())){
            System.out.println("Wrong confirm password");
            return;
        }

        Set<ConstraintViolation<UserRegisterDto>> violations =
                validationUtil.getViolations(userRegisterDto);

        if(!violations.isEmpty()){
            violations.stream().map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            return;
        }

        User user = modelMapper.map(userRegisterDto,User.class);
        if(userRepository.count() == 0){
            user.setAdmin(true);
        }
        try {
            userRepository.save(user);
            System.out.printf("%s was registered%n",user.getFullName());
        } catch (Exception e){
            System.out.println("Cannot have two users with the same email address");
        }


    }

    @Override
    public void loginUser(UserLoginDto userLoginDto) {
        Set<ConstraintViolation<UserLoginDto>> violation = validationUtil.getViolations(userLoginDto);

        if(!violation.isEmpty()){
            violation.stream().map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            return;
        }

        User user = userRepository.findByEmailAndPassword(userLoginDto.getEmail(),userLoginDto.getPassword()).orElse(null);

        if(user == null){
            System.out.println("Incorrect username / password");
            return;
        }

        loggedInUser = user;

    }

    @Override
    public void logout() {
        if(loggedInUser == null){
            System.out.println("Cannot log out. No user was logged in.");
        } else{
            loggedInUser = null;
        }
    }

    public boolean isLoggedUserAdmin() {
        return loggedInUser.isAdmin();
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    @Override
    public void printOwnedGames() {
        if(loggedInUser == null){
            System.out.println("There is no logged in user!");
            return;
        }
        UserGamesDto userGamesDto = modelMapper.map(loggedInUser,UserGamesDto.class);
        System.out.println(userGamesDto);
    }
}
