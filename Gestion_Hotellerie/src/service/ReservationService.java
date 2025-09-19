package service;

import entity.Reservation;
import entity.User;
import repository.InMemoryHotelRepository;
import repository.InMemoryReservationRepository;
import repository.InMemoryUserRepository;

import java.time.LocalDate;
import java.util.List;

public class ReservationService {
    private InMemoryReservationRepository reservationRepository;
    private InMemoryUserRepository userRepository;
    private InMemoryHotelRepository hotelRepository;

    public ReservationService(InMemoryReservationRepository inMemoryReservationRepository,InMemoryHotelRepository inMemoryHotelRepository,InMemoryUserRepository inMemoryUserRepository){
        reservationRepository = inMemoryReservationRepository ;
        userRepository = inMemoryUserRepository;
        hotelRepository = inMemoryHotelRepository;

    }

    public boolean makeReservation(User currentUser, String hotelName, LocalDate reservationDate, Integer nights){


        String userID = userRepository.getUserID(currentUser.getName());
        String hotelId = hotelRepository.getHotelId(hotelName);
        if(hotelRepository.hotelHasFreeRooms(hotelName)){
            reservationRepository.addReservation(userID,hotelId,reservationDate,nights);
            return true;
        }else{
            return false;
        }

    }
    public boolean cancelReservation(Integer indexOfReservation,User currentUser){
        String userID = userRepository.getUserID(currentUser.getName());
        List<Reservation> userReservations = reservationRepository.userReservations(currentUser.getId());
        String cancelingReservation = userReservations.get(indexOfReservation).getId();
        if(indexOfReservation <= userReservations.size() + 1){
        reservationRepository.cancelReservation(cancelingReservation);
            return true;
        }else {
            return false;
        }

    }
    public void userReservations(User currentUser){
      List <Reservation> userReservation = reservationRepository.userReservations(currentUser.getId());
        for (int i = 0; i < userReservation.size(); i++) {
            System.out.println((i + 1) + ". " + userReservation.get(i));
        }
    }
}
