package com.example.coffeshopexam.model.binding;

import javax.validation.constraints.Size;

public class UserLoginBandingModel {

    @Size(min = 5,max = 20)
    private String username;
    @Size(min = 3)
    private String password;

    public UserLoginBandingModel() {
    }

    public String getUsername() {
        return username;
    }

    public UserLoginBandingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLoginBandingModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
