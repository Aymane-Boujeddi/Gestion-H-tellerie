import repository.InMemoryHotelRepository;
import repository.InMemoryReservationRepository;
import repository.InMemoryUserRepository;
import service.AuthService;
import service.HotelService;
import service.ReservationService;
import utils.ConsoleUi;
import utils.Validation;

import java.util.Scanner;

public class GestionHotel {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        Validation validation = new Validation();

        InMemoryUserRepository inMemoryUserRepository = new InMemoryUserRepository();
        InMemoryHotelRepository inMemoryHotelRepository = new InMemoryHotelRepository();
        InMemoryReservationRepository inMemoryReservationRepository = new InMemoryReservationRepository();

        AuthService authService = new AuthService(inMemoryUserRepository);
        HotelService hotelService = new HotelService(inMemoryHotelRepository);
        ReservationService reservationService = new ReservationService(inMemoryReservationRepository,inMemoryHotelRepository,inMemoryUserRepository);



        ConsoleUi consoleUi = new ConsoleUi(scanner,authService,hotelService,reservationService,validation);

        consoleUi.authMenuUi();

    }
}
