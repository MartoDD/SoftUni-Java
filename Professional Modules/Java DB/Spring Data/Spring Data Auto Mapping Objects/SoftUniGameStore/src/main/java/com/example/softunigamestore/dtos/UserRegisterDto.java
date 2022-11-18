package com.example.softunigamestore.dtos;

import com.example.softunigamestore.constants.Validations;

import java.util.regex.Pattern;

public class UserRegisterDto {

    private String email;
    private String password;
    private String confirmPassword;
    private String fullName;

    public UserRegisterDto(String email, String password, String confirmPassword, String fullName) throws IllegalAccessException {
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.fullName = fullName;
        validate();
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    private void validate() throws IllegalAccessException {

        boolean matches = Pattern.matches(Validations.EMAIL_PATTERN,this.email);
        if (!matches){
            throw new IllegalArgumentException("Incorrect email.");
        }
        matches=Pattern.matches(Validations.PASSWORD_PATTERN,this.password);

        if (!matches){
            throw new IllegalArgumentException("Invalid password");
        }

        if (!this.password.equals(this.confirmPassword)){
            throw new IllegalArgumentException("Password does not match");
        }
    }
}
