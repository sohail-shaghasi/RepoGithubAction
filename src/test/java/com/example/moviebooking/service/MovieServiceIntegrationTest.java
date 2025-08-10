package com.example.moviebooking.service;

import com.example.moviebooking.Service.MovieService;
import com.example.moviebooking.models.Movie;
import com.example.moviebooking.repository.MovieRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
public class MovieServiceIntegrationTest {

    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieRepository movieRepository;

    @Test
    void testAddAndGetMovie() {
        Movie movie = new Movie(null, "Inception");
        movieService.addMovie(movie);

        List<Movie> movies = movieService.getAllMovies();
        assertEquals(1, movies.size());
    }
}

