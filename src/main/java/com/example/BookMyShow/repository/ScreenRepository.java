package com.example.BookMyShow.repository;

import com.example.BookMyShow.entity.Screen;
import com.example.BookMyShow.entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScreenRepository extends JpaRepository<Screen,Long> {

    List<Screen> findByTheaterId(Long theaterId);

    Screen getScreenById(Long screenId);
}
