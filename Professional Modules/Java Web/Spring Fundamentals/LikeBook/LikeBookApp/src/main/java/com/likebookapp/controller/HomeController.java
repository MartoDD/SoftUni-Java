package com.likebookapp.controller;

import com.likebookapp.model.binding.ReturnedPosts;
import com.likebookapp.model.entity.User;
import com.likebookapp.service.PostService;
import com.likebookapp.service.UserService;
import com.likebookapp.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
@RequestMapping
public class HomeController {

    private final CurrentUser currentUser;
    private final UserService userService;
    private final PostService postService;

    public HomeController(CurrentUser currentUser, UserService userService, PostService postService) {
        this.currentUser = currentUser;
        this.userService = userService;
        this.postService = postService;
    }

    @GetMapping("/")
    private String index() {

        if (currentUser.isLogged()) {
            return "redirect:/home";
        }
        return "index";
    }

    @GetMapping("/home")
    private String home(Model model) {

        User user = userService.findUserByUsername(currentUser.getUsername()).orElse(null);

        model.addAttribute("currentUserInfo", user);
        Set<ReturnedPosts> posts = postService.findAllPostsByUser(currentUser.getId());
        model.addAttribute("currentUserPosts", posts);
        Set<ReturnedPosts> postsFromOtherUsers=postService.findPostsByAllOtherUsers(currentUser.getId());
        model.addAttribute("otherUserPosts",postsFromOtherUsers);



        return "home";
    }
}
