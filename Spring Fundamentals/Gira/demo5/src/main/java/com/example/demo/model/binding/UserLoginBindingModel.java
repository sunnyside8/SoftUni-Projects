package com.example.demo.model.binding;

import javax.validation.constraints.Size;

public class UserLoginBindingModel {
    @Size(min = 3,max =20,message = "Email must be between 3 and 20 characters!")
    private String email;

    @Size(min = 3,max =20,message = "Password must be between 3 and 20 characters!")
    private String password;

    public UserLoginBindingModel() {
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public UserLoginBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
