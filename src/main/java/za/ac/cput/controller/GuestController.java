package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.Content.Guest;
import za.ac.cput.Factory.GuestFactory;
import za.ac.cput.Service.impl.GuestServiceImpl;

import java.util.Map;

@RestController
@RequestMapping("/HotelBookings/events")
public class GuestController {

    @Autowired
    private GuestServiceImpl service;

    @GetMapping("/create/{guestName}")
    public @ResponseBody
    Guest create(@PathVariable String guestName){
        Guest guest = GuestFactory.findGuest("Sebe", "0731906340", "10 Dorset Street");
        return service.create(guest);

    }
    @GetMapping("/getall")
    @ResponseBody
    public Map<Guest, Guest> getAll(){
        return service.getAll();
    }
}
