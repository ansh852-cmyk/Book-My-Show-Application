package com.example.BookMyShow.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "movies")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;
    private String genre;
    private String language;
    private String posterUrl;
    private Integer durationMinutes;
    private Double rating;
    private LocalDate releaseDate;

}
