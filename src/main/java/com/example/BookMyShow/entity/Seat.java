package com.example.BookMyShow.entity;


import com.example.BookMyShow.enums.SeatType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "seats")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String seatNumber;

    @Column(name = "seat_row")
    private String row;

    @Column(name = "seat_col")
    private Integer col;

    @Enumerated(EnumType.STRING)
    private SeatType seatType;

    @ManyToOne
    @JoinColumn(name = "screen_id",nullable = false)
    private Screen screen;

}
