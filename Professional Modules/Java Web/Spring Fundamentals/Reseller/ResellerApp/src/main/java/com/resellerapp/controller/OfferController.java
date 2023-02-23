package com.resellerapp.controller;

import com.resellerapp.model.dtos.OfferAddDto;
import com.resellerapp.service.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/offers")
public class OfferController {

    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @ModelAttribute
    private OfferAddDto offerAddDto() {
        return new OfferAddDto();
    }

    @GetMapping("/offer-add")
    private String addOffer() {
        return "offer-add";
    }

    @PostMapping("/offer-add")
    private String addOfferUser(@Valid OfferAddDto offerAddDto, BindingResult bindingResult,
                                RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("offerAddDto", offerAddDto)
                    .addFlashAttribute("org.springframework.validation.BindingResult.offerAddDto", bindingResult);
            return "redirect:/offers/offer-add";
        }

        offerService.addOffer(offerAddDto);

        return "redirect:/home";

    }

    @GetMapping("/remove/{id}")
    public String removeOffer(@PathVariable Long id) {
        offerService.removeOffer(id);

        return "redirect:/home";
    }

    @GetMapping("/buy/{id}")
    private String buyOffer(@PathVariable Long id) {

        offerService.buyOffer(id);

        return "redirect:/home";
    }
}
