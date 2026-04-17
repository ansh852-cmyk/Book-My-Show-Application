package com.example.BookMyShow.controller;

import com.example.BookMyShow.dto.ShowRequest;
import com.example.BookMyShow.entity.Show;
import com.example.BookMyShow.service.ShowService;
import com.example.BookMyShow.service.impl.ShowServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/shows")
@RequiredArgsConstructor
public class ShowController {

    private final ShowServiceInterface showService;

    @GetMapping
    public ResponseEntity<List<Show>> getAllShows()
    {
        return ResponseEntity.ok(showService.getAllShow());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Show> getShowById(@PathVariable Long id)
    {
        return ResponseEntity.ok(showService.getShowById(id));
    }

    @GetMapping("/movie/{movieId}")
    public ResponseEntity<List<Show>> getshowByMovie(@PathVariable Long movieId)
    {
        return ResponseEntity.ok(showService.getShowByMovie(movieId));
    }

    @GetMapping("/movie/{movieId}/date")
    public ResponseEntity<List<Show>>
    getShowByMovieAndDate(@PathVariable Long movieId, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date)
    {
        return ResponseEntity.ok(showService.getShowByMovieAndDate(movieId,date));
    }

    @PostMapping
    public Show addShow(@RequestBody ShowRequest request){
        return showService.addShow(request);
    }

}

