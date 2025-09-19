package repository;

import entity.Hotel;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryHotelRepository implements HotelRepository {

    Map<String, Hotel> hotels = new HashMap<>();


    @Override
    public void addHotel(String name,String adresse,Integer chambre,Double note) {

            Hotel newHotel = new Hotel(name,adresse,note,chambre);
            hotels.put(name,newHotel);

    }


    @Override
    public Hotel findByName(String name) {
        return hotels.get(name);
    }

    @Override
    public void allHotels() {
         hotels.values().forEach(System.out::println);
    }

    @Override
    public String getHotelId(String name) {
        return "";
    }

    @Override
    public boolean hotelHasFreeRooms(String name) {
        Integer rooms = hotels.get(name).getChambre();
        return rooms > 0;
    }


    @Override
    public void updateHotelName(Hotel hotel, String name) {

    }

    @Override
    public void updateHotelAddress(Hotel hotel, String address) {

    }

    @Override
    public void updateHotelRooms(Hotel hotel, String room_number) {

    }

    @Override
    public boolean hotelExisting(String name) {
        return hotels.containsKey(name);
    }

}
