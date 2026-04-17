package com.example.BookMyShow.repository;

import com.example.BookMyShow.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City,Long> {


    City getCityById(Long cityId);
}
