package com.example.BookMyShow.repository;

import com.example.BookMyShow.entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TheaterRepository extends JpaRepository<Theater,Long> {
    List<Theater> findByCityId(Long cityId);

    Theater getTheaterById(Long theaterId);
}
