package com.likebookapp.controller;

import com.likebookapp.model.binding.UserLoginModel;
import com.likebookapp.model.binding.UserRegisterBindingModel;
import com.likebookapp.service.UserService;
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

    @ModelAttribute(name = "userRegisterBindingModel")
    private UserRegisterBindingModel userRegisterBindingModel() {
        return new UserRegisterBindingModel();
    }

    @ModelAttribute(name = "userLoginModel")
    private UserLoginModel userLoginModel() {
        return new UserLoginModel();
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
    private String registerUser(@Valid UserRegisterBindingModel userRegisterBindingModel, BindingResult bindingResult,
                                RedirectAttributes redirectAttributes) {
        if (!userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())) {
            bindingResult.addError(new FieldError("differentPassword", "confirmPassword", "Password must match!"));
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);

            return "redirect:/users/register";
        }

        userService.registerUser(userRegisterBindingModel);


        return "redirect:/users/login";
    }

    @PostMapping("/login")
    private String loginUser(@Valid UserLoginModel userLoginModel, BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {


        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginModel", userLoginModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userLoginModel", bindingResult);

            return "redirect:/users/login";
        }

        if (!userService.validateCredentials(userLoginModel)) {
            redirectAttributes.addFlashAttribute("userLoginModel", userLoginModel)
                    .addFlashAttribute("validCredentials", false);

            return "redirect:/users/login";
        }
        userService.login(userLoginModel.getUsername());
        return "redirect:/home";
    }

    @GetMapping("/logout")
    private String logout() {
        userService.logout();
        return "redirect:/";
    }
}
