package com.example.BookMyShow.controller;

import com.example.BookMyShow.entity.Movie;
import com.example.BookMyShow.service.MovieService;
import com.example.BookMyShow.service.impl.MovieServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieServiceInterface movieService;


    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies()
    {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id)
    {
        return ResponseEntity.ok(movieService.getMovieById(id));
    }


    @GetMapping("/search")
    public ResponseEntity<List<Movie>> searchMovies(@RequestParam String title)
    {
        return ResponseEntity.ok(movieService.searchByTitle(title));
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<Movie>> getByGenre(@PathVariable String genre)
    {
        return ResponseEntity.ok(movieService.getByGenre(genre));
    }

    @GetMapping("/genre/{language}")
    public ResponseEntity<List<Movie>> getByLanguage(@PathVariable String language)
    {
        return ResponseEntity.ok(movieService.getByLanguage(language));
    }

    @PostMapping
    public Movie addMovie(@RequestBody Movie movie){
        return movieService.addMovie(movie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable Long id){
        movieService.deleteMovie(id);
        return ResponseEntity.ok("Deleted Successfully");
    }

}
