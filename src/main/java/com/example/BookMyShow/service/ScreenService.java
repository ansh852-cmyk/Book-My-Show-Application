package com.example.BookMyShow.service;

import com.example.BookMyShow.dto.ScreenRequest;
import com.example.BookMyShow.entity.Screen;
import com.example.BookMyShow.entity.Theater;
import com.example.BookMyShow.repository.ScreenRepository;
import com.example.BookMyShow.repository.TheaterRepository;
import com.example.BookMyShow.service.impl.ScreenServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ScreenService implements ScreenServiceInterface {

    private final ScreenRepository screenRepository;
    private final TheaterRepository theaterRepository;

    //addscreen
    public Screen addScreen(ScreenRequest request){

        Theater theater=theaterRepository.getTheaterById(request.getTheaterId());

        Screen screen= Screen.builder()
                .name(request.getName())
                .totalSeats(request.getTotalSeats())
                .theater(theater).build();

        return screenRepository.save(screen);
    }


    public List<Screen> getAllScreen()
    {
        return screenRepository.findAll();
    }

    public Screen getScreenById(Long id)
    {
        return screenRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Screen not found with id: "+id));

    }

    public List<Screen> getScreenByTheater(Long theaterId)
    {
        return screenRepository.findByTheaterId(theaterId);
    }

}
