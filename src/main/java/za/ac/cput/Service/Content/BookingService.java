package za.ac.cput.Service.Content;

import za.ac.cput.Domain.Content.Booking;
import za.ac.cput.Service.GenIService;

import java.util.List;
import java.util.Map;

public interface BookingService extends GenIService<Booking, String> {

    List<Booking> getAll();
    Booking retrieveById(String id);
}
