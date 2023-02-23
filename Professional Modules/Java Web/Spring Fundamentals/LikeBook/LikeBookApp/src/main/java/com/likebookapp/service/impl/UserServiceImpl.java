package com.likebookapp.service.impl;

import com.likebookapp.model.binding.UserLoginModel;
import com.likebookapp.model.binding.UserRegisterBindingModel;
import com.likebookapp.model.entity.User;
import com.likebookapp.repository.UserRepository;
import com.likebookapp.service.UserService;
import com.likebookapp.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    private final CurrentUser currentUser;

    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository, CurrentUser currentUser) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }

    @Override
    public void registerUser(UserRegisterBindingModel userRegisterBindingModel) {

        User user = modelMapper.map(userRegisterBindingModel, User.class);
        userRepository.save(user);
        this.login(user.getUsername());

    }

    @Override
    public Optional<User> findUserByUsername(String name) {
        return userRepository.findUserByUsername(name);
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return this.userRepository.findUserByEmail(email);
    }

    @Override
    public boolean validateCredentials(UserLoginModel userLoginModel) {

        Optional<User> user = this.userRepository.findUserByUsername(userLoginModel.getUsername());

        if (user.isEmpty()) {
            return false;
        }

        return user.get().getPassword().equals(userLoginModel.getPassword());
    }

    @Override
    public void login(String username) {

        Optional<User> user = userRepository.findUserByUsername(username);

        currentUser.setId(user.get().getId());
        currentUser.setUsername(user.get().getUsername());
    }

    @Override
    public void logout() {
        currentUser.setId(null);
        currentUser.setUsername(null);
    }
}
