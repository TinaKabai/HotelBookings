package za.ac.cput.Service;

import za.ac.cput.Domain.Content.Booking;

import java.util.Map;

public interface BookingService extends IService<Booking, String> {

    Map<Booking, Booking> getAll();
}
