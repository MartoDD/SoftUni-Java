package com.resellerapp.service;

import com.resellerapp.model.dtos.UserLoginDto;
import com.resellerapp.model.dtos.UserRegisterDto;
import com.resellerapp.model.entity.User;
import com.resellerapp.repository.UserRepository;
import com.resellerapp.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public UserService(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    public Optional<User> findUserByEmail(String email) {
        return this.userRepository.findUserByEmail(email);
    }

    public Optional<User> findUserByUsername(String username) {
        return this.userRepository.findUserByUsername(username);
    }

    public void registerUser(UserRegisterDto userRegisterDto) {

        User user = modelMapper.map(userRegisterDto, User.class);
        userRepository.save(user);
        this.login(user.getUsername());
    }

    public void login(String username) {

        User user = userRepository.findUserByUsername(username).orElse(null);
        currentUser.setId(user.getId());
        currentUser.setUsername(user.getUsername());
    }

    public void logout() {
        currentUser.setId(null);
        currentUser.setUsername(null);
    }

    public boolean validateCredentials(UserLoginDto userLoginDto){

        Optional<User>user = userRepository.findUserByUsername(userLoginDto.getUsername());

        if (user.isEmpty()){
            return false;
        }

        return user.get().getPassword().equals(userLoginDto.getPassword());

    }
}
