package com.example.BookMyShow.service.impl;

import com.example.BookMyShow.entity.Movie;

import java.util.List;

public interface MovieServiceInterface {

    public Movie addMovie(Movie movie);
    public List<Movie> getAllMovies();
    public Movie getMovieById(Long id);
    public List<Movie> searchByTitle(String title);
    public List<Movie> getByGenre(String genre);
    public List<Movie> getByLanguage(String language);
    public void deleteMovie(Long id);
}
