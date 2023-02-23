package com.likebookapp.util;

import com.likebookapp.service.UserService;
import com.likebookapp.util.annotations.UniqueUsername;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    private final UserService userService;

    public UniqueUsernameValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean isValid(String values, ConstraintValidatorContext context) {
        return this.userService.findUserByUsername(values).isEmpty();
    }
}
