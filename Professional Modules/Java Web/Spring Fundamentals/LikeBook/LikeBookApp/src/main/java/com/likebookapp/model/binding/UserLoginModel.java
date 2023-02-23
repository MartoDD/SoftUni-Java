package com.likebookapp.model.binding;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserLoginModel {

    @NotBlank(message =  "Please input a non blank username!")
    @Size(min = 3, max = 20, message = "Please input a username with length between 3 and 20 characters!")
    private String username;
    @NotBlank(message =  "Please input a non blank password!")
    @Size(min = 3, max = 20, message = "Please input a password with length between 3 and 20 characters!")
    private String password;

    public UserLoginModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
