package com.activities.bits.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping
    public String renderHomePage(Model model) {
        return "home.html";
    }

    @GetMapping("/movies")
    public String renderMoviesPage(Model model) {
        model.addAttribute("movies", null);
        return "movies.html";
    }
}
