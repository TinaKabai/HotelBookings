package za.ac.cput.Service;

import za.ac.cput.Domain.Content.Hotel;

import java.util.Set;

public interface HotelService extends IService<Hotel, String> {

    Set<Hotel> getAll();
}
