/*package za.ac.cput.Repository.Implementation;

import org.springframework.stereotype.Repository;
import za.ac.cput.Domain.Content.Hotel;
import za.ac.cput.Repository.content.HotelRepository;

import java.util.HashSet;
import java.util.Set;

@Repository*/
/*public class HotelRepositoryImpl implements HotelRepository {

    private static HotelRepositoryImpl repository = null;
    private Set<Hotel> hotels;

    private HotelRepositoryImpl() {
        this.hotels = new HashSet<>();
    }

    private Hotel findHotel(String hotelName) {
        return this.hotels.stream()
                .filter(hotel -> hotel.getHotelName().trim().equals(hotelName))
                .findAny()
                .orElse(null);
    }

    public static HotelRepositoryImpl getRepository() {
        if (repository == null) repository = new HotelRepositoryImpl();
        return repository;
    }

    public Hotel create(Hotel hotel){
        this.hotels.add(hotel);
        return hotel;
    }

    public Hotel read(final String hotelName){
        Hotel hotel = findHotel(hotelName);
        return hotel;
    }

    public void delete(String hotelName) {
        Hotel hotel = findHotel(hotelName);
        if (hotel != null) this.hotels.remove(hotel);
    }

    public Hotel update(Hotel hotel){
        Hotel toDelete = findHotel(hotel.getHotelName());
        if(toDelete != null) {
            this.hotels.remove(toDelete);
            return create(hotel);
        }
        return null;
    }

    public Set<Hotel> getAll(){
        return this.hotels;
    }
}*/
