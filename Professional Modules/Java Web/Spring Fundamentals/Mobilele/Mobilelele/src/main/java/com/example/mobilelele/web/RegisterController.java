package com.example.mobilelele.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class RegisterController {

    @GetMapping("/register")
    public ModelAndView register(ModelAndView reg){
        reg.setViewName("auth-register");
        return reg;
    }

}
