package com.cinema.app.cmsapp.service;

import com.cinema.app.cmsapp.entity.MovieCast;

import java.util.List;

public interface MovieCastService
{
    List<MovieCast> getAllMovieCast();

    void saveMovieCast(MovieCast movieCast);
}
