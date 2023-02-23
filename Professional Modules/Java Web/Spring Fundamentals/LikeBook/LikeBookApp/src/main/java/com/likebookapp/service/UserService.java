package com.likebookapp.service;

import com.likebookapp.model.binding.UserLoginModel;
import com.likebookapp.model.binding.UserRegisterBindingModel;
import com.likebookapp.model.entity.User;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface UserService {

    public void registerUser(UserRegisterBindingModel userRegisterBindingModel);

    Optional<User> findUserByUsername(String name);

    Optional<User> findUserByEmail(String email);

    boolean validateCredentials(UserLoginModel userLoginModel);

    void login(String username);

    void logout();
}
