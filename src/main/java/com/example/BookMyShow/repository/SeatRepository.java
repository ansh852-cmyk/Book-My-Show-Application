package com.example.BookMyShow.repository;

import com.example.BookMyShow.entity.Screen;
import com.example.BookMyShow.entity.Seat;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat,Long> {

    List<Seat> findByScreenId(Long screenId);
}
