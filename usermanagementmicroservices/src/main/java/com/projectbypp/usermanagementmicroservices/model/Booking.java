package com.projectbypp.usermanagementmicroservices.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Getter
@Setter
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "Booking")

public class Booking {

    @Transient
    public static final String SEQUENCE_NAME = "booking_sequence";

    @Id

    private int bookingId;



    @Digits(integer = 5, fraction = 0)

    private int trainNum;


    @Pattern(regexp = "^[A-Za-z -]+$", message = "Only alphabets allowed and - character allowed")
    @Size(min = 3, max = 20, message = "min 3 max 20 alphabets")

    private String trainName;



    private int passengerId;


    @Pattern(regexp = "^[A-Za-z\\s]+$", message = "Only alphabets and spaces are allowed")
    @Size(min = 3, max = 15, message = "min 3 max 15 alphabets")

    private String passengerName;


    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,20}$"
            , message = "Email should be in the format abc@gmail.com")

    private String email;


    @Pattern(regexp = "^\\d{10}$", message = "Phone number should be of 10 digits")

    private String phone;


    @Pattern(regexp = "^\\d{2}-\\d{2}-\\d{4}$", message = "Only digits are allowed for date in the format dd-mm-yyyy")

    private String bookingDate;


    @Pattern(regexp = "^\\d{2}-\\d{2}-\\d{4}$", message = "Only digits are allowed for date in the format dd-mm-yyyy")

    private String journeyDate;


    @Pattern(regexp = "^[A-Za-z -]+$", message = "Only alphabets allowed and - character allowed")
    @Size(min = 3, max = 20, message = "min 3 max 20 alphabets")

    private String sourceStation;


    @Pattern(regexp = "^[A-Za-z -]+$", message = "Only alphabets allowed and - character allowed")
    @Size(min = 3, max = 20, message = "min 3 max 20 alphabets")

    private String destinationStation;

    @NotEmpty(message = "Required")
    @Pattern(regexp = "^[A-Za-z0-9 -]+$", message = "Only alphabets and digits allowed with space and \"-\". No other special characters allowed")
    @Size(min = 3, max = 20, message = "Min 3 and max 20 alphabets allowed")

    private String trainClass;

    @NotNull
    @Digits(integer = 1, fraction = 0)

    private int totalNumOfSeats;

    @NotNull
    @Digits(integer = 4, fraction = 2)

    private double price;

    @Valid
    private List<Passengers> passengers;

    @Pattern(regexp = "[0-2][0-9]:[0-5][0-9]:[0-5][0-9]$", message = "time should be in 00:00:00 format")
    @Size(min = 8, max = 8, message = "time should be in 00:00:00")
    private String sourcetimeOfArrival;

    @Pattern(regexp = "[0-2][0-9]:[0-5][0-9]:[0-5][0-9]$", message = "time should be in 00:00:00 format")
    @Size(min = 8, max = 8, message = "time should be in 00:00:00")
    private String sourcetimeOfDeparture;

    @Pattern(regexp = "[0-2][0-9]:[0-5][0-9]:[0-5][0-9]$", message = "time should be in 00:00:00 format")
    @Size(min = 8, max = 8, message = "time should be in 00:00:00")
    private String destinationtimeOfArrival;



}