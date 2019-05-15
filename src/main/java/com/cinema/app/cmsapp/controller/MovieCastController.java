package com.cinema.app.cmsapp.controller;

import com.cinema.app.cmsapp.entity.MovieCast;
import com.cinema.app.cmsapp.service.MovieCastService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/movieCast")
public class MovieCastController
{
    private MovieCastService movieCastService;

    public MovieCastController(MovieCastService movieCastService)
    {
        this.movieCastService = movieCastService;
    }

    @GetMapping("/list")
    public String getMovieCastList(Model model)
    {
        //List<MovieCast> movieCastList = movieCastService.getAllMovieCast();

        //model.addAttribute("movieCastList", movieCastList);

        return "moviescast/movieCastList";
    }
}
