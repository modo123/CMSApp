package com.cinema.app.cmsapp.service;

import com.cinema.app.cmsapp.dao.MovieRepository;
import com.cinema.app.cmsapp.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService
{
    private MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository)
    {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> getAllMovies()
    {
        return movieRepository.findAll();
    }

    @Override
    public void saveMovie(Movie movie)
    {
        movieRepository.save(movie);
    }
}
