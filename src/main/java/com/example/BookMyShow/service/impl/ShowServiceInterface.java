package com.example.BookMyShow.service.impl;

import com.example.BookMyShow.dto.ShowRequest;
import com.example.BookMyShow.entity.Show;

import java.time.LocalDate;
import java.util.List;

public interface ShowServiceInterface {
    public Show addShow(ShowRequest request);
    public List<Show> getAllShow();
    public List<Show> getShowByMovie(Long movieId);
    public Show getShowById(Long id);
    public List<Show> getShowByMovieAndDate(Long movieId, LocalDate date);

}
