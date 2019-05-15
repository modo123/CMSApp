package com.cinema.app.cmsapp.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "movie")
public class Movie
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "original_title")
    private String originalTitle;

    @Column(name = "polish_title")
    private String polishTitle;

    @Column(name = "category")
    private String category;

    @Column(name = "duration")
    private int duration;

    @OneToMany(mappedBy = "movie",
                fetch = FetchType.LAZY,
                cascade = CascadeType.ALL)
    private List<MovieShow> movieShowList;

    @ManyToMany(fetch = FetchType.LAZY,
                cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "movie_movie_cast",
                joinColumns = @JoinColumn(name = "movie_id"),
                inverseJoinColumns = @JoinColumn(name = "movie_cast_id"))
    private List<MovieCast> movieCastList;

    public Movie() {
    }

    public Movie(String originalTitle, String polishTitle, String category, int duration, List<MovieShow> movieShowList, List<MovieCast> movieCastList) {
        this.originalTitle = originalTitle;
        this.polishTitle = polishTitle;
        this.category = category;
        this.duration = duration;
        this.movieShowList = movieShowList;
        this.movieCastList = movieCastList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getPolishTitle() {
        return polishTitle;
    }

    public void setPolishTitle(String polishTitle) {
        this.polishTitle = polishTitle;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public List<MovieShow> getMovieShowList() {
        return movieShowList;
    }

    public void setMovieShowList(List<MovieShow> movieShowList) {
        this.movieShowList = movieShowList;
    }

    public List<MovieCast> getMovieCastList() {
        return movieCastList;
    }

    public void setMovieCastList(List<MovieCast> movieCastList) {
        this.movieCastList = movieCastList;
    }
}
