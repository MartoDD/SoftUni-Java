package com.example.softunigamestore.services.user;

import org.springframework.stereotype.Service;


public interface UserService {

    String registerUser(String[] args) throws IllegalAccessException;
    String loginUser(String[]args);
    String logoutUser();
}
