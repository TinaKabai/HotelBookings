package za.ac.cput.Repository;

import za.ac.cput.Domain.Content.Hotel;

import java.util.Set;

public interface HotelRepository extends IRepository<Hotel, String> {

    Set<Hotel> getAll();
}
