package com.resellerapp.model.dtos;

import com.resellerapp.vallidation.annotations.UniqueEmail;
import com.resellerapp.vallidation.annotations.UniqueUsername;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRegisterDto {
    @NotBlank(message = "Username must not be blank!")
    @UniqueUsername
    @Size(min = 3, max = 20, message = "Username length must be between 3 and 20 characters!")
    private String username;
    @Email(message = "Enter a valid email!")
    @UniqueEmail
    @NotBlank(message = "Email cannot be empty!")
    private String email;
    @NotBlank(message = "Password cannot be blank!")
    @Size(min = 3, max = 20,message = "Password length must be between 3 and 20 characters!")
    private String password;
    @NotBlank(message = "Password cannot be blank!")
    @Size(min = 3, max = 20,message = "Password length must be between 3 and 20 characters!")
    private String confirmPassword;

    public UserRegisterDto() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
