package com.cinema.app.cmsapp.service;

import com.cinema.app.cmsapp.entity.Movie;

import java.util.List;

public interface MovieService
{
    List<Movie> getAllMovies();

    void saveMovie(Movie movie);
}
