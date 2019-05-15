package com.cinema.app.cmsapp.dao;

import com.cinema.app.cmsapp.entity.MovieShow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieShowRepository extends JpaRepository<MovieShow, Integer>
{

}
