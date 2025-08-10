package com.example.moviebooking.service;

import com.example.moviebooking.Service.MovieService;
import com.example.moviebooking.models.Movie;
import com.example.moviebooking.repository.MovieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MovieServiceTest {
    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private MovieService movieService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllMovies(){
        Movie movie1 = new Movie(11L, "Inception");
        Movie movie2 = new Movie(12L, "Avatar");
        when(movieRepository.findAll()).thenReturn(Arrays.asList(movie1, movie2));

        List<Movie> movies = movieService.getAllMovies();

        assertEquals(2, movies.size());
        verify(movieRepository, times(1)).findAll();
    }


}
