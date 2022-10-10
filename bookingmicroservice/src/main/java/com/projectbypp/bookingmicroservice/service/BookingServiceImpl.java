package com.projectbypp.bookingmicroservice.service;



import com.projectbypp.bookingmicroservice.model.*;
import com.projectbypp.bookingmicroservice.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static com.projectbypp.bookingmicroservice.model.Booking.SEQUENCE_NAME;


@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private RestTemplate restTemplate;


    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    public SequenceGeneratorService sequenceGeneratorService;

    @Override
    public Booking addbooking(Booking booking) {
        return bookingRepository.save(booking);
    }


    @Override
    public Optional<Booking> viewbooking(int bookingId) {
        return bookingRepository.findById(bookingId);
    }

    @Override
    public List<Booking> viewbookingbyTid( int trainNum) {
        List<Booking> booking;
        booking = bookingRepository.search(trainNum);
        return booking;

    }

    @Override
    public List<Booking> getBookings()
    {
        return bookingRepository.findAll();
    }




    @Override
    public  List<Booking> findByEmail(String email) {
        return bookingRepository.findByEmail(email);
    }

}
