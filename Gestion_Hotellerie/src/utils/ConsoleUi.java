package utils;

import entity.Hotel;
import entity.User;
import repository.InMemoryHotelRepository;
import repository.InMemoryUserRepository;
import service.AuthService;
import service.HotelService;
import service.ReservationService;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingDeque;

public class ConsoleUi {
    private Scanner scanner ;
    private AuthService authService ;
    private HotelService hotelService;
    private ReservationService reservationService;
    private User currentUser;
    private Validation validation;

    public ConsoleUi(Scanner scanner, AuthService authService, HotelService hotelService,ReservationService reservationService,Validation validation){
        this.scanner = scanner;
        this.authService = authService;
        this.hotelService = hotelService;
        this.reservationService = reservationService;
        this.validation = validation;
    }

    public void authMenuUi(){


        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Password: ");
                    String password = scanner.nextLine();
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("lastname: ");
                    String lastname = scanner.nextLine();

                    boolean success = authService.register(name ,email, password,lastname,"user");
                    if (success) {
                        System.out.println("Registration successful!");
                    } else {
                        System.out.println("Email already exists.");
                    }
                }
                case 2 -> {
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Password: ");
                    String password = scanner.nextLine();

                    boolean success = authService.login(email, password);
                    if (success) {
                        currentUser = authService.getCurrentUser(email);
                        mainMenuUi(currentUser);
                        System.out.println("chi haja");
                    } else {
                        System.out.println("Invalid credentials.");
                    }
                }

                case 0 -> { return; }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    public void mainMenuUi(User currentUser){


        while(true){

            System.out.println("1. Create Hotel");
            System.out.println("2. List Hotels");
            System.out.println("3. Reserve Room");
            System.out.println("4. Cancel Reservation");
            System.out.println("5. Reservation History");
            System.out.println("6. Update Profile");
            System.out.println("7. Change Password");
            System.out.println("8. Logout");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 1 -> createHotel();
                case 2 -> listHotels();
                case 3 -> reserveRoom();
                case 4 -> cancelReservation();
                case 5 -> reservationHistory();
                case 6 -> updateProfile();
                case 7 -> changePassword();
                case 8 -> logout();
                case 0 -> { return; }
                default -> System.out.println("Invalid choice!");
            }




        }
    }

    public void createHotel(){
        System.out.println("Fill out the information of the hotel :");
        System.out.println("Hotel name :");
        String hotelName = scanner.next();
        System.out.println("Hotel address :");
        String hotelAddress = scanner.next();
        System.out.println("Hotel Rating :");
        Double hotelRating = scanner.nextDouble();

        System.out.println("Number of rooms :");
        Integer hotelRoomNumbers = scanner.nextInt();

        boolean success = hotelService.createHotel(hotelName,hotelAddress,hotelRoomNumbers,hotelRating);
        if(success){
            System.out.println("Hotel created successfully !");
        }else{
            System.out.println("This hotel name is already existing");
        }

    }
    public void listHotels(){
            hotelService.allHotels();
    }
    public void reserveRoom(){
        System.out.println("Enter the hotel name :");
        String reserveHotelName = scanner.next();
        if(hotelService.hotelExiscting(reserveHotelName)){
            System.out.println("Choose a reservation date (YYYY-MM-DD) : ");
            String reservationDateInput = scanner.nextLine();
            LocalDate reservationDate = LocalDate.parse(reservationDateInput);
            Integer nights = scanner.nextInt();


        }
    }
    public void cancelReservation(){
        reservationService.userReservations(currentUser);
        System.out.println("Choose the reservation you want to cancel : ");
        Integer IndexofReservation = scanner.nextInt();
        reservationService.cancelReservation(IndexofReservation,currentUser);

    }
    public void reservationHistory(){}
    public void updateProfile(){
        while(true){
            System.out.println("Choose what you want to update in you profile : ");
            System.out.println("1. Change your name.");
            System.out.println("2. Change your lastname.");
            System.out.println("3. Change your email");
            System.out.println("4. Change your password.");
        }
    }
    public void changePassword(){}
    public void logout(){}

}

