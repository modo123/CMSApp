package com.cinema.app.cmsapp.dao;

import com.cinema.app.cmsapp.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer>
{

}
