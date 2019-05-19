package com.cinema.app.cmsapp.service;

import com.cinema.app.cmsapp.dao.MovieShowRepository;
import com.cinema.app.cmsapp.entity.MovieShow;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieShowServiceImpl implements MovieShowService
{
    private MovieShowRepository movieShowRepository;

    public MovieShowServiceImpl(MovieShowRepository movieShowRepository)
    {
        this.movieShowRepository = movieShowRepository;
    }

    @Override
    public List<MovieShow> getAllMovieShows()
    {
        return movieShowRepository.findAll();
    }

    @Override
    public void addMovieShow(MovieShow movieShow)
    {
        movieShowRepository.save(movieShow);
    }
}
