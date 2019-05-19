package com.cinema.app.cmsapp.controller;

import com.cinema.app.cmsapp.entity.CinemaHall;
import com.cinema.app.cmsapp.entity.Movie;
import com.cinema.app.cmsapp.entity.MovieShow;
import com.cinema.app.cmsapp.service.CinemaHallService;
import com.cinema.app.cmsapp.service.MovieService;
import com.cinema.app.cmsapp.service.MovieShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/movieShow")
public class MovieShowController
{
    private MovieShowService movieShowService;
    private MovieService movieService;
    private CinemaHallService cinemaHallService;

    @Autowired
    public MovieShowController(MovieShowService movieShowService, MovieService movieService, CinemaHallService cinemaHallService)
    {
        this.movieShowService = movieShowService;
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }

    @GetMapping("/list")
    public String getAllMovieShows(Model model)
    {
        List<MovieShow> movieShowsList = movieShowService.getAllMovieShows();

        model.addAttribute("movieShowsList", movieShowsList);

        return "movieshows/movieShowList";
    }

    @GetMapping("/showMovieShowAddForm")
    public String showMovieShowAddForm(Model model)
    {
        MovieShow movieShow = new MovieShow();
        List<Movie> moviesList = movieService.getAllMovies();
        List<CinemaHall> cinemaHallsList = cinemaHallService.getAllCinemaHalls();

        model.addAttribute("movieShow", movieShow);
        model.addAttribute("moviesList", moviesList);
        model.addAttribute("cinemaHallsList", cinemaHallsList);

        return "movieshows/movieShowAddForm";
    }

    @PostMapping("/save")
    public String saveMovieShow(@ModelAttribute("movieShow") MovieShow movieShow)
    {
        movieShowService.addMovieShow(movieShow);

        return "redirect:/movieShow/list";
    }
}
