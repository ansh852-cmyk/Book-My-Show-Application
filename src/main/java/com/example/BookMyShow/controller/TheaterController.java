package com.example.BookMyShow.controller;

import com.example.BookMyShow.dto.TheaterRequest;
import com.example.BookMyShow.entity.Theater;
import com.example.BookMyShow.service.TheaterService;
import com.example.BookMyShow.service.impl.TheaterServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/theaters")
@RequiredArgsConstructor
public class TheaterController {

    private final TheaterServiceInterface theaterService;

    //post add
    @PostMapping
    public Theater addTheater(@RequestBody TheaterRequest theater){
        return theaterService.addTheater(theater);
    }

    @GetMapping
    public ResponseEntity<List<Theater>> getAllTheaters()
    {
        return ResponseEntity.ok(theaterService.getAllTheaters());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Theater> getTheaterById(@PathVariable Long id)
    {
        return ResponseEntity.ok(theaterService.getTheaterById(id));
    }

    @GetMapping("/city/{cityId}")
    public ResponseEntity<List<Theater>> getTheaterByCity(@PathVariable Long cityId)
    {
        return ResponseEntity.ok(theaterService.getTheaterByCity(cityId));
    }


}
