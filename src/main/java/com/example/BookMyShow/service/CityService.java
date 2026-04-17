package com.example.BookMyShow.service;

import com.example.BookMyShow.entity.City;
import com.example.BookMyShow.repository.CityRepository;
import com.example.BookMyShow.service.impl.CityServiceInterface;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CityService implements CityServiceInterface {
    private final CityRepository cityRepository;

    public City addCity(City city)
    {
        return cityRepository.save(city);
    }

    public List<City> getAllCities()
    {
        return cityRepository.findAll();
    }

    public City getCityById(Long id)
    {
        return cityRepository.findById(id)
                .orElseThrow(()->new RuntimeException("City not found with id: "+id));
    }
}
