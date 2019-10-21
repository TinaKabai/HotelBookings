package za.ac.cput.Service.Content;

import za.ac.cput.Domain.Content.Hotel;
import za.ac.cput.Service.GenIService;

import java.util.List;
import java.util.Set;

public interface HotelService extends GenIService<Hotel, String> {

    Hotel retrieveById(String id);
    List<Hotel> getAll();
}
