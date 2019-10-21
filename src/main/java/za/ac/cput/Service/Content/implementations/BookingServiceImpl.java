package za.ac.cput.Service.Content.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Content.Booking;
import za.ac.cput.Repository.content.BookingRepository;
import za.ac.cput.Service.Content.BookingService;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private static BookingService service = null;

    @Autowired
    private BookingRepository repo;

    private BookingServiceImpl(){

    }

    public static BookingService getService()
    {
        if(service == null) service = new BookingServiceImpl();
        return service;
    }

    @Override
    public Booking retrieveById(String id)
    {
        List<Booking> bookings = getAll();
        for(Booking b: bookings)
        {
            if (b.getName().equals(id)) return b;
        }
        return null;
    }

    @Override
    public List<Booking> getAll() {
        return this.repo.findAll();
    }

    public Booking create(Booking booking) {
        return this.repo.save(booking);
    }


    public Booking read(String s) {
        return this.repo.findById(s).orElse(null);
    }


    public Booking update(Booking booking) {
        return this.repo.save(booking);
    }

    @Override
    public void delete(String s) {
        this.repo.deleteById(s);
    }
}
