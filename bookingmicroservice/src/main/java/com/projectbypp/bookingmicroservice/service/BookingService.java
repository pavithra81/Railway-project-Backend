package com.projectbypp.bookingmicroservice.service;


import com.projectbypp.bookingmicroservice.model.Booking;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

public interface BookingService {

    Booking addbooking(Booking booking);


    public List<Booking> viewbookingbyTid(int trainNum);

    public Optional<Booking> viewbooking(int bookingId);

    public List<Booking> getBookings();



    List<Booking> findByEmail(String email);
}
