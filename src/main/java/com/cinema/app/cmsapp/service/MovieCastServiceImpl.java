package com.cinema.app.cmsapp.service;

import com.cinema.app.cmsapp.dao.MovieCastRepository;
import com.cinema.app.cmsapp.entity.MovieCast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieCastServiceImpl implements MovieCastService
{
    private MovieCastRepository movieCastRepository;

    @Autowired
    public MovieCastServiceImpl(MovieCastRepository movieCastRepository)
    {
        this.movieCastRepository = movieCastRepository;
    }

    @Override
    public List<MovieCast> getAllMovieCast()
    {
        return movieCastRepository.findAll();
    }
}
