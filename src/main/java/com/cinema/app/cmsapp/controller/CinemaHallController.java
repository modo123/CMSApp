package com.cinema.app.cmsapp.controller;

import com.cinema.app.cmsapp.entity.CinemaHall;
import com.cinema.app.cmsapp.service.CinemaHallService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cinemaHalls")
public class CinemaHallController
{
    private CinemaHallService cinemaHallService;

    public CinemaHallController(CinemaHallService cinemaHallService)
    {
        this.cinemaHallService = cinemaHallService;
    }

    @GetMapping("/list")
    public String getAllCinemaHalls(Model model)
    {
        List<CinemaHall> cinemaHallsList = cinemaHallService.getAllCinemaHalls();

        model.addAttribute("cinemaHallsList", cinemaHallsList);

        return "halls/cinemaHallList.html";
    }

    @GetMapping("showCinemaHallAddForm")
    public String showCinemaHallAddForm(Model model)
    {
        CinemaHall cinemaHall = new CinemaHall();

        model.addAttribute("cinemaHall", cinemaHall);

        return "halls/cinemaHallAddForm";
    }

    @PostMapping("/save")
    public String saveCinemaHall(@ModelAttribute("cinemaHall") CinemaHall cinemaHall)
    {
        cinemaHallService.saveCinemaHall(cinemaHall);

        return "redirect:/cinemaHalls/list";
    }
}
