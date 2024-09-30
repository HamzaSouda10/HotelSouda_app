package com.Souda.Souda_Hotel.dto;

import com.Souda.Souda_Hotel.entity.Room;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

    private int statusCode;
    private  String message;

    private String token;
    private String role;
    private String expirationTime;
    private String BookingConfirmationCode;

    private UserDTO user;
    private RoomDTO room;
    private BookingDTO booking;
    private List<UserDTO> userList;
    private List<RoomDTO> roomList;
    private List<BookingDTO> bookList;
}
