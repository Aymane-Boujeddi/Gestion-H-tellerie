package service;

import entity.Hotel;
import repository.InMemoryHotelRepository;

import java.util.Collection;

public class HotelService {

    private  InMemoryHotelRepository inMemoryHotelRepository ;

    public HotelService(InMemoryHotelRepository inMemoryHotelRepository){
        this.inMemoryHotelRepository = inMemoryHotelRepository;
    }


    public boolean createHotel(String name,String address,Integer rooms,Double rating){
        if(this.inMemoryHotelRepository.hotelExisting(name)){
                return false;
        }else{
            this.inMemoryHotelRepository.addHotel(name, address, rooms, rating);
            return true;
        }
    }
    public void allHotels(){
       this.inMemoryHotelRepository.allHotels();
    }
    public boolean hotelExiscting(String name){
        return inMemoryHotelRepository.hotelExisting(name);
    }

    
}
