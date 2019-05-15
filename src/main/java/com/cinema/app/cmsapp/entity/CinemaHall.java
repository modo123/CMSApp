package com.cinema.app.cmsapp.entity;

import javax.persistence.*;

@Entity
@Table(name = "cinema_hall")
public class CinemaHall
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "hall_number")
    private int hallNumber;

    @Column(name = "num_of_seats")
    private int numOfSeats;

    public CinemaHall() {
    }

    public CinemaHall(int hallNumber, int numOfSeats) {
        this.hallNumber = hallNumber;
        this.numOfSeats = numOfSeats;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHallNumber() {
        return hallNumber;
    }

    public void setHallNumber(int hallNumber) {
        this.hallNumber = hallNumber;
    }

    public int getNumOfSeats() {
        return numOfSeats;
    }

    public void setNumOfSeats(int numOfSeats) {
        this.numOfSeats = numOfSeats;
    }
}
