package com.example.moviebooking.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;

    private LocalDateTime bookingTime;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
}
