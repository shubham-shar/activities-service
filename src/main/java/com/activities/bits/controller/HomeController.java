package com.activities.bits.controller;

import com.activities.bits.service.EventService;
import com.activities.bits.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    @Autowired
    MovieService movieService;

    @Autowired
    EventService eventService;

    @GetMapping({"/", "/home"})
    public String renderHomePage(Model model) {
        return "home.html";
    }

    @GetMapping("/movies")
    public String renderMoviesPage(Model model) {
        model.addAttribute("movies", movieService.getMovies());
        return "movies.html";
    }

    @GetMapping("/events")
    public String renderEventsPage(Model model) {
        model.addAttribute("events", eventService.getEvents());
        return "events.html";
    }

    @GetMapping("/movies/{id}")
    public String renderMoviesPage(@PathVariable Long id, Model model) {
        model.addAttribute("movie", movieService.getMovie(id));
        return "movie.html";
    }

    @GetMapping("/events/{id}")
    public String renderEventsPage(@PathVariable Long id, Model model) {
        model.addAttribute("event", eventService.getEvent(id));
        return "event.html";
    }
}
