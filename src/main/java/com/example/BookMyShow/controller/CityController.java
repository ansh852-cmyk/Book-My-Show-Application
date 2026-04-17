package com.example.BookMyShow.controller;

import com.example.BookMyShow.entity.City;
import com.example.BookMyShow.service.CityService;
import com.example.BookMyShow.service.impl.CityServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
@RequiredArgsConstructor
public class CityController {

    private final CityServiceInterface cityService;


    @GetMapping
    public ResponseEntity<List<City>> getAllCities()
    {
        return ResponseEntity.ok(cityService.getAllCities());
    }

    @GetMapping("{id}")
    public ResponseEntity<City> getAllCities(@PathVariable Long id)
    {
        return ResponseEntity.ok(cityService.getCityById(id));
    }

    @PostMapping
    public City AddCity(@RequestBody City city){
        return cityService.addCity(city);
    }
}
