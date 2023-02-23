package com.resellerapp.controller;

import com.resellerapp.model.dtos.UserLoginDto;
import com.resellerapp.model.dtos.UserRegisterDto;
import com.resellerapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute
    private UserRegisterDto userRegisterDto() {
        return new UserRegisterDto();
    }

    @ModelAttribute
    private UserLoginDto userLoginDto() {
        return new UserLoginDto();
    }

    @ModelAttribute
    public void addAttribute(Model model) {
        model.addAttribute("validCredentials");
    }

    @GetMapping("/register")
    private String register() {
        return "register";
    }

    @GetMapping("/login")
    private String login() {
        return "login";
    }

    @PostMapping("/register")
    private String registerUser(@Valid UserRegisterDto userRegisterDto, BindingResult bindingResult,
                                RedirectAttributes redirectAttributes) {

        if (!userRegisterDto.getPassword().equals(userRegisterDto.getConfirmPassword())) {

            bindingResult.addError(new FieldError("differentPasswords", "confirmPassword", "Password must match!"));

        }

        if (bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("userRegisterDto", userRegisterDto)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegisterDto", bindingResult);

            return "redirect:/users/register";
        }
        userService.registerUser(userRegisterDto);

        return "redirect:/users/login";
    }

    @PostMapping("/login")
    private String loginUser(@Valid UserLoginDto userLoginDto, BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginDto", userLoginDto)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userLoginDto", bindingResult);
            return "redirect:/users/login";
        }

        if (!userService.validateCredentials(userLoginDto)) {
            redirectAttributes.addFlashAttribute("userLoginDto", userLoginDto)
                    .addFlashAttribute("validCredentials", false);

            return "redirect:/users/login";
        }

        userService.login(userLoginDto.getUsername());
        return "redirect:/home";

    }

    @GetMapping("/logout")
    private String logout() {
        this.userService.logout();

        return "redirect:/";
    }
}
