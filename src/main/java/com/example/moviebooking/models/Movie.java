package com.example.moviebooking.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
public class Movie {
    @Id
    @GeneratedValue
    private Long id;

    @JsonProperty("movie_name")
    private String name;

    private String genre;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Booking> bookings = new ArrayList<>();

    public Movie(Long id, String movieName) {
        this.id = id;
        this.name = movieName;
    }
    protected Movie() {}
}
