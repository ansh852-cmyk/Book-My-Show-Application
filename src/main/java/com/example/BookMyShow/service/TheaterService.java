package com.example.BookMyShow.service;

import com.example.BookMyShow.dto.TheaterRequest;
import com.example.BookMyShow.entity.City;
import com.example.BookMyShow.entity.Theater;
import com.example.BookMyShow.repository.CityRepository;
import com.example.BookMyShow.repository.TheaterRepository;
import com.example.BookMyShow.service.impl.TheaterServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TheaterService implements TheaterServiceInterface {
    private final TheaterRepository theaterRepository;
    private final CityRepository cityRepository;


    public Theater addTheater(TheaterRequest request)
    {

        City city=cityRepository.getCityById(request.getCityId());
        Theater theater=Theater.builder()
                .name(request.getName())
                .address(request.getAddress())
                .city(city)
                .build();
        return theaterRepository.save(theater);
    }

    public List<Theater> getAllTheaters()
    {
        return theaterRepository.findAll();
    }

    public Theater getTheaterById(Long id)
    {
        return theaterRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Theater not found with id: "+id));

    }

    public List<Theater> getTheaterByCity(Long cityId)
    {
        return theaterRepository.findByCityId(cityId);
    }
}
