package com.example.BookMyShow.controller;

import com.example.BookMyShow.dto.SeatRequest;
import com.example.BookMyShow.entity.Seat;
import com.example.BookMyShow.service.SeatService;
import com.example.BookMyShow.service.impl.SeatServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seats")
@RequiredArgsConstructor
public class SeatController {

    private final SeatServiceInterface seatService;

    @GetMapping("/screen/{screenId}")
    public ResponseEntity<List<Seat>> getSeatByScreen(@PathVariable Long screenId)
    {
        return ResponseEntity.ok(seatService.getSeatsByScreen(screenId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Seat> getSeatById(@PathVariable Long id)
    {
        return ResponseEntity.ok(seatService.getSeatById(id));
    }

    @PostMapping
    public Seat addSeat(@RequestBody SeatRequest request){
        return seatService.addSeat(request);
    }

}
