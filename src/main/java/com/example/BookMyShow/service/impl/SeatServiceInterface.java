package com.example.BookMyShow.service.impl;

import com.example.BookMyShow.dto.SeatRequest;
import com.example.BookMyShow.entity.Seat;

import java.util.List;

public interface SeatServiceInterface {
    public List<Seat> getSeatsByScreen(Long screenId);
    public Seat getSeatById(Long id);
    public Seat addSeat(SeatRequest request);
}
