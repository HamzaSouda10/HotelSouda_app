package com.Souda.Souda_Hotel.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.apache.catalina.User;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull(message = "check in date is required")
    private LocalDate checkInDate;
    @Future(message = "check out date must be in the future")
    private LocalDate checkoutDate;

    @Min(value= 0 , message = "Number of adults must not be less than 0")
    private int numOfAdults;

    @Min(value= 0 , message = "Number of children must not be less than 0")
    private int numOfChildren;

    private int totalNumOfGuest;
    private String bookingConfirmationCode;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "room_id")
    private Room room;

    public void calculateTotalNumberOfGuest(){
        this.totalNumOfGuest=this.numOfAdults+this.numOfChildren;

    }

    public void setNumOfAdults(int numOfAdults){
        this.numOfAdults= numOfAdults;
        calculateTotalNumberOfGuest();
    }

    public void setNumOfChildren(int numOfChildren){
        this.numOfChildren= numOfChildren;
        calculateTotalNumberOfGuest();
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingConfirmationCode='" + bookingConfirmationCode + '\'' +
                ", id=" + id +
                ", checkInDate=" + checkInDate +
                ", checkoutDate=" + checkoutDate +
                ", numOfAdults=" + numOfAdults +
                ", numOfChildren=" + numOfChildren +
                ", totalNumOfGuest=" + totalNumOfGuest +
                ", user=" + user +
                ", room=" + room +
                '}';
    }
}
