package com.example.springmappingobjectsex.models.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

public class UserLoginDto {

    @Email(message = "Incorrect username / password")
    private String email;

    @Pattern(regexp = "[A-Za-z\\d]{6,}",message = "Incorrect username / password")
    private String password;


    public UserLoginDto() {
    }

    public UserLoginDto(String email, String password) {
        this.email = email;
        this.password = password;
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

    public void setPassword(String password) {
        this.password = password;
    }
}
