package com.Souda.Souda_Hotel.dto;

import com.Souda.Souda_Hotel.entity.Room;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.apache.catalina.User;


import java.time.LocalDate;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookingDTO {
    private long id;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int numOfAdults;
    private int numOfChildren;
    private int totalNumOfGuest;
    private String bookingConfirmationCode;
    private User user;
    private Room room;
}
