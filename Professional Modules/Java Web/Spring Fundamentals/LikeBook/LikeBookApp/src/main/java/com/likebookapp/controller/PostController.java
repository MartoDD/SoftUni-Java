package com.likebookapp.controller;

import com.likebookapp.model.binding.PostUploadModel;
import com.likebookapp.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @ModelAttribute
    public PostUploadModel postUploadModel() {
        return new PostUploadModel();
    }


    @GetMapping("/add-post")
    public String addPost() {
        return "post-add";
    }

    @PostMapping("/add-post")
    public String uploadPost(@Valid PostUploadModel postUploadModel, BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("postUploadModel", postUploadModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.postUploadModel", bindingResult);

            return "redirect:/posts/add-post";
        }

        this.postService.addPost(postUploadModel);

        return "redirect:/home";
    }

    @GetMapping("/remove/{id}")
    public String removePost(@PathVariable Long id) {

        postService.removePost(id);

        return "redirect:/home";
    }

    @GetMapping("/like/{id}")
    public String likePost(@PathVariable Long id) {

        postService.likePost(id);
        return "redirect:/home";
    }
}
