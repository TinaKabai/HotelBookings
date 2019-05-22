package za.ac.cput.Service.impl;

import za.ac.cput.Domain.Content.Booking;
import za.ac.cput.Repository.BookingRepository;
import za.ac.cput.Repository.Implementation.BookingRepositoryImpl;
import za.ac.cput.Service.BookingService;

import java.util.Map;

public class BookingServiceImpl implements BookingService {

    private BookingServiceImpl service = null;
    private BookingRepository repository;

    private BookingServiceImpl(){
        this.repository = BookingRepositoryImpl.getRepository();
    }

    public BookingService getService(){
        if (service == null) service = new BookingServiceImpl();
        return null;
    }

    @Override
    public Booking create(Booking booking) {
        return this.repository.create(booking);
    }

    @Override
    public Booking update(Booking booking) {
        return this.repository.update(booking);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Booking read(String s) {
        return this.repository.read(s);
    }

    public Map<Booking, Booking> getAll() {
        return this.repository.getAll();
    }
}
