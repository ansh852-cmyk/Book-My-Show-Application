package com.example.BookMyShow.service.impl;

import com.example.BookMyShow.dto.TheaterRequest;
import com.example.BookMyShow.entity.Theater;

import java.util.List;

public interface TheaterServiceInterface {
    public Theater addTheater(TheaterRequest request);
    public List<Theater> getAllTheaters();
    public Theater getTheaterById(Long id);
    public List<Theater> getTheaterByCity(Long cityId);
}
