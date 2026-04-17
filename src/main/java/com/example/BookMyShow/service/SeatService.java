package com.example.BookMyShow.service;

import com.example.BookMyShow.dto.SeatRequest;
import com.example.BookMyShow.entity.Screen;
import com.example.BookMyShow.entity.Seat;
import com.example.BookMyShow.repository.ScreenRepository;
import com.example.BookMyShow.repository.SeatRepository;
import com.example.BookMyShow.service.impl.SeatServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeatService implements SeatServiceInterface {

    private final SeatRepository seatRepository;
    private final ScreenRepository screenRepository;

    //addSeat
    public Seat addSeat(SeatRequest request){
        Screen screen=screenRepository.getScreenById(request.getScreenId());
        Seat seat= Seat.builder()
                .seatType(request.getSeatType())
                .seatNumber(request.getSeatNumber())
                .col(request.getCol())
                .screen(screen)
                .row(request.getRow())
        .build();
        return seatRepository.save(seat);
    }

    public List<Seat> getSeatsByScreen(Long screenId)
    {
        return seatRepository.findByScreenId(screenId);
    }

    public Seat getSeatById(Long id)
    {
        return seatRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Seat not found with id: "+id));

    }
}
