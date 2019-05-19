package com.cinema.app.cmsapp.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "movie_show")
public class MovieShow
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "start_movie")
    private Date startMovieDate;

    @Column(name = "end_movie")
    private Date endMovieDate;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "hall_id")
    private CinemaHall cinemaHall;

    public MovieShow() {
    }

    public MovieShow(Date startMovieDate, Date endMovieDate, Movie movie, CinemaHall cinemaHall) {
        this.startMovieDate = startMovieDate;
        this.endMovieDate = endMovieDate;
        this.movie = movie;
        this.cinemaHall = cinemaHall;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartMovieDate() {
        return startMovieDate;
    }

    public void setStartMovieDate(Date startMovieDate) {
        this.startMovieDate = startMovieDate;
    }

    public Date getEndMovieDate() {
        return endMovieDate;
    }

    public void setEndMovieDate(Date endMovieDate) {
        this.endMovieDate = endMovieDate;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public CinemaHall getCinemaHall() {
        return cinemaHall;
    }

    public void setCinemaHall(CinemaHall cinemaHall) {
        this.cinemaHall = cinemaHall;
    }
}
