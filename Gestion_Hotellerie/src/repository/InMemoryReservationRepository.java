package repository;

import entity.Reservation;
import entity.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryReservationRepository implements ReservationRepository{
    Map<String , List<Reservation>> reservations = new HashMap<>();


    @Override
    public void addReservation(String userId, String hotelId, LocalDate reservationDate, Integer nights) {
            Reservation newReservation = new Reservation(userId,hotelId,nights,reservationDate);
            if(!reservations.containsKey(userId)){
                List<Reservation> userReservations = new ArrayList<>();
                userReservations.add(newReservation);
                reservations.put(userId,userReservations);
            }else{
                reservations.get(userId).add(newReservation);
            }
    }

    @Override
    public void cancelReservation(String reservationId) {

    }

    @Override
    public List<Reservation> userReservations(String userID) {
       return reservations.get(userID);
    }
}
