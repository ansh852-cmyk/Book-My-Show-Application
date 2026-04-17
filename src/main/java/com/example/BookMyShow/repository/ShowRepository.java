package com.example.BookMyShow.repository;

import com.example.BookMyShow.entity.Show;
import com.example.BookMyShow.entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ShowRepository extends JpaRepository<Show,Long> {
    List<Show> findByMovieId(Long movieId);
    List<Show> findByScreenId(Long screenId);
    List<Show> findByMovieIdAndShowDate(Long movieId, LocalDate showDate);
    List<Show> findByScreenIdAndShowDate(Long screenId,LocalDate showDate);

    Show findShowById(Long showId);
}
