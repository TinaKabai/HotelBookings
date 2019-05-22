package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.Content.Booking;
import za.ac.cput.Factory.BookingFactory;
import za.ac.cput.Service.impl.BookingServiceImpl;

import java.util.Map;

@RestController
@RequestMapping("/HotelBookings/booking")
public class BookingController {
    @Autowired
    private BookingServiceImpl service;

    @GetMapping("/create/{booking}")
    public @ResponseBody
    Booking create(@PathVariable String bookings){
        Booking booking = BookingFactory.bookings(true);
        return service.create(booking);

    }
    @GetMapping("/getall")
    @ResponseBody
    public Map<Booking, Booking> getAll(){
        return service.getAll();
    }
}
