package com.example.demo.model.binding;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserRegisterBindingModel {

    @NotBlank(message = "Username cannot be empty")
    @Size(min = 3,max =10,message = "Username must be between 3 and 10 characters!")
    private String username;

    @Email(message = "Email has to contain @")
    private String email;

    @NotBlank(message = "Pass cannot be empty")
    @Size(min = 3,message = "Password must be more than 3 characters")
    private String password;

    @Size(min = 3,max =20,message = "Full name must be between 3 and 20 characters!")
    private String fullName;

    @NotBlank(message = "Pass cannot be empty")
    private String confirmPassword;

    public UserRegisterBindingModel() {
    }

    public String getUsername() {
        return username;
    }

    public UserRegisterBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserRegisterBindingModel setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }
}
