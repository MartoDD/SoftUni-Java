package com.example.softunigamestore.services.user;

import com.example.softunigamestore.constants.Messages;
import com.example.softunigamestore.dtos.UserLoginDto;
import com.example.softunigamestore.dtos.UserRegisterDto;
import com.example.softunigamestore.entities.User;
import com.example.softunigamestore.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    private User user;
    private UserLoginDto userLogin;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String registerUser(String[] args) throws IllegalAccessException {
        String email = args[1];
        String password = args[2];
        String confirmPassword = args[3];
        String fullName = args[4];

        UserRegisterDto userRegister = new UserRegisterDto(email, password, confirmPassword, fullName);
        User user = this.modelMapper.map(userRegister, User.class);

        if (userRepository.count() == 0) {
            user.setAdmin(true);
        }

        User isUserFound = this.userRepository.findByEmail(userRegister.getEmail());
        if (isUserFound != null) {
            throw new IllegalArgumentException(Messages.ALREADY_REGISTERED);
        }
        this.userRepository.save(user);

        return String.format(Messages.USER_REGISTERED, user.getFullName());
    }

    @Override
    public String loginUser(String[] args) {
        String email = args[1];
        String password = args[2];


        this.user = userRepository.findByEmail(email);

        if (user == null || !user.getPassword().equals(password)) {
            throw new IllegalArgumentException(Messages.INCORRECT_CREDENTIALS);
        }

        userLogin = modelMapper.map(user, UserLoginDto.class);

        return String.format(Messages.SUCCESSFUL_LOGIN, user.getFullName());
    }

    @Override
    public String logoutUser() {

        if (userLogin == null) {
            throw new IllegalArgumentException(Messages.CANNOT_LOGOUT);
        }
        String name = userLogin.getFullName();
        userLogin = null;

        return String.format(Messages.SUCCESSFUL_LOGOUT, name);
    }
}
