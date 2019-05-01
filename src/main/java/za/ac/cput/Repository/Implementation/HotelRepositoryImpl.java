package za.ac.cput.Repository.Implementation;

import za.ac.cput.Domain.Content.Hotel;
import za.ac.cput.Repository.HotelRepository;

import java.util.HashSet;
import java.util.Set;

public class HotelRepositoryImpl implements HotelRepository {

    private static HotelRepositoryImpl repository = null;
    private Set<Hotel> hotels;

    private HotelRepositoryImpl() {
        this.hotels = new HashSet<Hotel>();
    }

    public static HotelRepositoryImpl getRepository() {
        if (repository == null) repository = new HotelRepositoryImpl();
        return repository;
    }


    public Hotel create(Hotel hotel) {
        this.hotels.add(hotel);
        return hotel;
    }

    public Hotel read(String hotelName) {
        // find the course that matches the id and return it if exist
        return null;
    }

    public void delete(String hotelName) {
        // find the course, delete it if it exist
    }

    public Hotel update(Hotel hotel) {
        // find the course, update it and delete it if it exists
        return hotel;
    }

    public Set<Hotel> getAll(){
        return this.hotels;
    }
}
