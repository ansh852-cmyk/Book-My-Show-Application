package com.example.BookMyShow.service;

import com.example.BookMyShow.entity.Movie;
import com.example.BookMyShow.repository.MovieRepository;
import com.example.BookMyShow.service.impl.MovieServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService implements MovieServiceInterface {
    private final MovieRepository movieRepository;

    public Movie addMovie(Movie movie)
    {
        return movieRepository.save(movie);
    }

    public List<Movie> getAllMovies()
    {
        return movieRepository.findAll();
    }

    public Movie getMovieById(Long id)
    {
        return movieRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Movie not found with id: "+id));

    }

    public List<Movie> searchByTitle(String title){
        return movieRepository.findByTitleContainingIgnoreCase(title);
    }

    public List<Movie> getByGenre(String genre){
        return movieRepository.findByGenre(genre);
    }

    public List<Movie> getByLanguage(String language){
        return movieRepository.findByLanguage(language);
    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

    //update movie

    //delete movie
}
