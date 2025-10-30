package com.reljicd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.reljicd.service.PostService;

@Controller
public class HomeController {

    @Autowired
    private PostService postService;

    @GetMapping("/home")
    public String home(Model model) {
        int page = 0;
        int size = 10;
        var pageable = PageRequest.of(page, size, Sort.by("id").descending());
        model.addAttribute("posts", postService.findAllPosts(pageable));
        return "home";
    }
}
