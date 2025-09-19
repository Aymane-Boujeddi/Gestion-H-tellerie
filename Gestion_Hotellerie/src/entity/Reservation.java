package entity;

import java.util.UUID;
import java.time.LocalDate;


public class Reservation {
   private String id;
   private String userID;
   private String hotelId;
   private Integer nights;
   private LocalDate reservationDate;

   public Reservation(String userID, String hotelId,Integer nights, LocalDate reservationDate){
    this.userID = userID;
    this.hotelId = hotelId;
    this.nights = nights;
    this.reservationDate = reservationDate;
    this.id = UUID.randomUUID().toString();
   }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_id() {
        return userID;
    }

    public void setUser_id(String userID) {
        this.userID = userID;
    }

    public String getHotel_id() {
        return hotelId;
    }

    public void setHotel_id(String hotelId) {
        this.hotelId = hotelId;
    }

    public Integer getNights() {
        return nights;
    }

    public void setNights(Integer nights) {
        this.nights = nights;
    }

    public LocalDate getReservation_date() {
        return reservationDate;
    }

    public void setReservation_date(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }
}
