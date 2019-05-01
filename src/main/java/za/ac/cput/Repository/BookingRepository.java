package za.ac.cput.Repository;

import za.ac.cput.Domain.Content.Booking;

import java.util.Set;

public interface BookingRepository extends IRepository<Booking, String> {

    Set<Booking> getAll();
}
