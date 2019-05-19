package com.cinema.app.cmsapp.service;

import com.cinema.app.cmsapp.entity.CinemaHall;

import java.util.List;

public interface CinemaHallService
{
    List<CinemaHall> getAllCinemaHalls();

    void saveCinemaHall(CinemaHall cinemaHall);
}
