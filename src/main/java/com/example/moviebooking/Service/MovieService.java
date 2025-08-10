package com.example.moviebooking.Service;

import com.example.moviebooking.models.Movie;
import com.example.moviebooking.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private static final Logger logger = LoggerFactory.getLogger(MovieService.class);
    @Autowired
    private MovieRepository movieRepository;

    @Cacheable
    public List<Movie> getAllMovies(){
        logger.info("Fetching all movies from repository");
        return movieRepository.findAll();
    }

    public Movie addMovie(Movie movie){
        logger.info("Adding new movie: {}", movie);
        return movieRepository.save(movie);
    }
    public Optional<Movie> getMovieById(Long id){
        logger.info("Getting movie with id: {}", id);
        return movieRepository.findById(id);
    }
}
