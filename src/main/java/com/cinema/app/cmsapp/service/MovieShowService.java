package com.cinema.app.cmsapp.service;

import com.cinema.app.cmsapp.entity.MovieShow;

import java.util.List;

public interface MovieShowService
{
    List<MovieShow> getAllMovieShows();

    void addMovieShow(MovieShow movieShow);
}
