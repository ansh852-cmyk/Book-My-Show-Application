package com.example.BookMyShow.repository;

import com.example.BookMyShow.entity.Movie;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie,Long> {

    List<Movie> findByGenre(String genre);
    List<Movie> findByLanguage(String language);
    List<Movie> findByTitleContainingIgnoreCase(String title);
}
