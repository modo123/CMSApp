package com.cinema.app.cmsapp.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "movie_cast")
public class MovieCast
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "cast_role")
    private String role;

    @ManyToMany(fetch = FetchType.LAZY,
                cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "movie_movie_cast",
            joinColumns = @JoinColumn(name = "movie_cast_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private List<Movie> moviesList;

    public MovieCast() {
    }

    public MovieCast(String firstName, String lastName, String role, List<Movie> moviesList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.moviesList = moviesList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Movie> getMoviesList() {
        return moviesList;
    }

    public void setMoviesList(List<Movie> moviesList) {
        this.moviesList = moviesList;
    }
}
