package za.ac.cput.Repository;

import za.ac.cput.Domain.Content.Booking;

import java.util.Map;

public interface BookingRepository extends IRepository<Booking, String> {

    Map<Booking, Booking> getAll();
}
