package za.ac.cput.Repository.Implementation;

import za.ac.cput.Domain.Content.Booking;
import za.ac.cput.Repository.BookingRepository;

import java.util.HashSet;
import java.util.Set;

public class BookingRepositoryImpl implements BookingRepository {

    private static BookingRepositoryImpl repository = null;
    private Set<Booking> bookings;

    private BookingRepositoryImpl() {
        this.bookings = new HashSet<Booking>();
    }

    public static BookingRepositoryImpl getRepository() {
        if (repository == null) repository = new BookingRepositoryImpl();
        return repository;
    }


    public Booking create(Booking booking) {
        this.bookings.add(booking);
        return booking;
    }

    public Booking read(String name) {
        // find the course that matches the id and return it if exist
        return null;
    }

    public void delete(String name) {
        // find the course, delete it if it exist
    }

    public Booking update(Booking booking) {
        // find the course, update it and delete it if it exists
        return booking;
    }

    public Set<Booking> getAll(){
        return this.bookings;
    }
}
