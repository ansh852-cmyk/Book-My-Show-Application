package com.example.BookMyShow.controller;

import com.example.BookMyShow.dto.ScreenRequest;
import com.example.BookMyShow.entity.Screen;
import com.example.BookMyShow.service.ScreenService;
import com.example.BookMyShow.service.impl.ScreenServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/screens")
@RequiredArgsConstructor
public class ScreenController {

    private final ScreenServiceInterface screenService;

    @GetMapping
    public ResponseEntity<List<Screen>> getAllScreens()
    {
        return ResponseEntity.ok(screenService.getAllScreen());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Screen> getScreenById(@PathVariable Long id)
    {
        return ResponseEntity.ok(screenService.getScreenById(id));
    }

    @GetMapping("/theater/{theaterId}")
    public ResponseEntity<List<Screen>>  getScreenByTheaterId(@PathVariable Long theaterId)
    {
        return ResponseEntity.ok(screenService.getScreenByTheater(theaterId));
    }

    @PostMapping
    public Screen addScreen(@RequestBody ScreenRequest request){
        return screenService.addScreen(request);
    }
}

