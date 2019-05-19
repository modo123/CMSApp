package com.cinema.app.cmsapp.controller;

import com.cinema.app.cmsapp.entity.Movie;
import com.cinema.app.cmsapp.entity.MovieCast;
import com.cinema.app.cmsapp.service.MovieCastService;
import com.cinema.app.cmsapp.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieController
{
    private MovieService movieService;
    private MovieCastService movieCastService;

    public MovieController(MovieService movieService, MovieCastService movieCastService)
    {
        this.movieService = movieService;
        this.movieCastService = movieCastService;
    }

//    public MovieController(MovieCastService movieCastService)
//    {
//        this.movieCastService = movieCastService;
//    }

    @GetMapping("/list")
    public String getAllMovies(Model model)
    {
        List<Movie> moviesList = movieService.getAllMovies();

        model.addAttribute("moviesList", moviesList);

        return "movies/movieList.html";
    }

    @GetMapping("/showMovieAddForm")
    public String showMovieAddForm(Model model)
    {
        Movie movie = new Movie();
        List<MovieCast> movieCastList = movieCastService.getAllMovieCast();

        model.addAttribute("movie", movie);
        model.addAttribute("movieCastList", movieCastList);

        return "movies/movieAddForm.html";
    }

    @PostMapping("/save")
    public String saveMovie(@ModelAttribute("movie") Movie movie)
    {
        movieService.saveMovie(movie);

        return "redirect:/movies/list";
    }
}
