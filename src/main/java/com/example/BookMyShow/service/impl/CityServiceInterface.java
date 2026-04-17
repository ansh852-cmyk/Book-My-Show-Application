package com.example.BookMyShow.service.impl;

import com.example.BookMyShow.entity.City;
import com.example.BookMyShow.repository.CityRepository;

import java.util.List;

public interface CityServiceInterface {

    public City addCity(City city);
    public List<City> getAllCities();
    public City getCityById(Long id);
}
