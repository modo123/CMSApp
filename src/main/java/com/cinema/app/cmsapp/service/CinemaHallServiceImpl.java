package com.cinema.app.cmsapp.service;

import com.cinema.app.cmsapp.dao.CinemaHallRepository;
import com.cinema.app.cmsapp.entity.CinemaHall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaHallServiceImpl implements CinemaHallService
{
    private CinemaHallRepository cinemaHallRepository;

    @Autowired
    public CinemaHallServiceImpl(CinemaHallRepository cinemaHallRepository)
    {
        this.cinemaHallRepository = cinemaHallRepository;
    }

    @Override
    public List<CinemaHall> getAllCinemaHalls()
    {
       return cinemaHallRepository.findAll();
    }

    @Override
    public void saveCinemaHall(CinemaHall cinemaHall)
    {
        cinemaHallRepository.save(cinemaHall);
    }
}
