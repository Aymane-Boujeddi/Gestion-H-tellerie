package repository;

import entity.Hotel;

import java.util.Collection;

public interface HotelRepository {
    public void addHotel(String name,String adresse,Integer chambre,Double note);
    Hotel findByName(String name);
    public void allHotels();
    public String getHotelId(String name);
    public boolean hotelHasFreeRooms(String name);
    public void updateHotelName(Hotel hotel,String name);
    public void updateHotelAddress(Hotel hotel,String address);
    public void updateHotelRooms(Hotel hotel,String room_number);
    public boolean hotelExisting(String name);

}
