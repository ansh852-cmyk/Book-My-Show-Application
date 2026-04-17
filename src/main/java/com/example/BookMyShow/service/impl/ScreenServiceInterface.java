package com.example.BookMyShow.service.impl;

import com.example.BookMyShow.dto.ScreenRequest;
import com.example.BookMyShow.entity.Screen;

import java.util.List;

public interface ScreenServiceInterface {
    public List<Screen> getAllScreen();
    public Screen getScreenById(Long id);
    public List<Screen> getScreenByTheater(Long theaterId);
    public Screen addScreen(ScreenRequest request);
}
