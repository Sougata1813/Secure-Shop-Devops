package com.reljicd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index"; // loads index.html from templates or static folder
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }
}
