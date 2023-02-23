package com.resellerapp.controller;

import com.resellerapp.model.dtos.ReturnedOffersDto;
import com.resellerapp.model.entity.User;
import com.resellerapp.service.OfferService;
import com.resellerapp.service.UserService;
import com.resellerapp.util.CurrentUser;
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
    private final OfferService offerService;

    public HomeController(CurrentUser currentUser, UserService userService, OfferService offerService) {
        this.currentUser = currentUser;
        this.userService = userService;
        this.offerService = offerService;
    }

    @GetMapping("/")
    private String index() {
        return "index";
    }

    @GetMapping("/home")
    private String home(Model model) {

        User user = userService.findUserByUsername(currentUser.getUsername()).orElse(null);

        model.addAttribute("currentUserInfo", user);
        Set<ReturnedOffersDto> userOffers = offerService.findAllOffersByUser(currentUser.getId());
        model.addAttribute("currentUserOffers", userOffers);
        Set<ReturnedOffersDto> otherUsersOffers = offerService.findAllOffersByOtherUsers(currentUser.getId());
        model.addAttribute("otherUserOffers", otherUsersOffers);
        Set<ReturnedOffersDto> boughtItems;


        return "home";
    }

}
