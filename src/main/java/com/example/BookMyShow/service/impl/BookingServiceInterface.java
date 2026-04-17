package com.example.BookMyShow.service.impl;

import com.example.BookMyShow.dto.BookingRequest;
import com.example.BookMyShow.entity.Booking;
import com.example.BookMyShow.entity.Seat;
import com.example.BookMyShow.entity.Show;
import com.example.BookMyShow.entity.User;
import com.example.BookMyShow.enums.BookingStatus;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BookingServiceInterface {

    public Booking createBooking(BookingRequest request);
    public Booking getBookingById(Long id);
    public List<Booking> getBookingByUser(Long userId);
    public Booking cancelbooking(Long bookingid);
    public List<Seat> getAvailableSeats(Long showId);
}
