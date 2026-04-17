package com.example.BookMyShow.service;

import com.example.BookMyShow.dto.BookingRequest;
import com.example.BookMyShow.entity.Booking;
import com.example.BookMyShow.entity.Seat;
import com.example.BookMyShow.entity.Show;
import com.example.BookMyShow.entity.User;
import com.example.BookMyShow.enums.BookingStatus;
import com.example.BookMyShow.repository.BookingRepository;
import com.example.BookMyShow.repository.SeatRepository;
import com.example.BookMyShow.repository.ShowRepository;
import com.example.BookMyShow.repository.UserRepository;
import com.example.BookMyShow.service.impl.BookingServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService implements BookingServiceInterface {

    private final BookingRepository bookingRepository;
    private final SeatRepository seatRepository;
    private final UserRepository userRepository;
    private final ShowRepository showRepository;

    @Transactional
    public Booking createBooking(BookingRequest request)
    {
        User user=userRepository.findUserById(request.getUserId());
        Show show=showRepository.findShowById(request.getShowId());

        //if the requested seat are already booked
        List<Long> alreadyBookedSeats=bookingRepository.findBookedSeatIdsByShowId(show.getId());
        for(Long seatId:request.getSeatIds())
        {
            if(alreadyBookedSeats.contains(seatId))
            {
                throw new RuntimeException("Seat with id "+seatId+" is already Booked");
            }
        }

        List<Seat> seats=seatRepository.findAllById(request.getSeatIds());
        if(seats.size()!=request.getSeatIds().size())
        {
            throw new RuntimeException("Some Seats Are Invalid");
        }

        double totalPrice=seats.size()*show.getTicketPrice();
        Booking booking=Booking.builder()
                .user(user)
                .show(show)
                .seats(seats)
                .totalPrice(totalPrice)
                .status(BookingStatus.CONFIRMED)
                .build();

        return bookingRepository.save(booking);
    }

    public Booking getBookingById(Long id)
    {
        return bookingRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Booking not found with id: "+id));

    }

    public List<Booking> getBookingByUser(Long userId)
    {
        return bookingRepository.findByUserId(userId);
    }

    @Transactional
    public Booking cancelbooking(Long bookingid)
    {
        Booking booking=getBookingById(bookingid);
        booking.setStatus(BookingStatus.CANCELLED);
        return bookingRepository.save(booking);
    }

    public List<Seat> getAvailableSeats(Long showId)
    {
        Show show=showRepository.findShowById(showId);
        List<Seat> allSeats=seatRepository.findByScreenId(show.getScreen().getId());
        List<Long> bookingSeatIds=bookingRepository.findBookedSeatIdsByShowId(showId);
        return allSeats.stream()
                .filter(seat -> !bookingSeatIds.contains(seat.getId()))
                .toList();
    }

}
