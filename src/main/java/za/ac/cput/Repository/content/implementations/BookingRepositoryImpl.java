/*package za.ac.cput.Repository.Implementation;

import za.ac.cput.Domain.Content.Booking;
import za.ac.cput.Repository.content.BookingRepository;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository*/
/*public class BookingRepositoryImpl implements BookingRepository {

    private static BookingRepositoryImpl repository = null;
    private Map<Booking, Booking> bookings;

    private BookingRepositoryImpl() {
        this.bookings = new HashMap<>();
    }

    private Booking booked(String guestName) {
        return this.bookings.values().stream()
                .filter(booking -> booking.getName().trim().equals(guestName))
                .findAny()
                .orElse(null);
    }

    public static BookingRepositoryImpl getRepository() {
        if (repository == null) repository = new BookingRepositoryImpl();
        return repository;
    }

    public Booking create(Booking booking) {
        this.bookings.put(booking, booking);
        return booking;
    }

    public Booking read(final String guestName){
        Booking booking = booked(guestName);
        return booking;
    }

    public void delete(String guestName) {
        Booking booking = booked(guestName);
        if (booking != null) this.bookings.remove(booking);
    }

    public Booking update(Booking booking) {
        Booking toDelete = booked(booking.getName());
        if(toDelete != null) {
            this.bookings.remove(toDelete);
        }
        return create(toDelete);
    }

    public Map<Booking, Booking> getAll(){
        return this.bookings;
    }
}*/
