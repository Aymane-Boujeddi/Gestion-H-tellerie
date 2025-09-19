package repository;

import entity.Hotel;
import entity.Reservation;
import entity.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

public interface ReservationRepository {

public void addReservation(String userId, String hotelId, LocalDate reservationDate,Integer nights);
public void cancelReservation(String reservationId);
public List<Reservation> userReservations(String userID);

}
