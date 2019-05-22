package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.Content.Hotel;
import za.ac.cput.Factory.HotelFactory;
import za.ac.cput.Service.impl.HotelServiceImpl;

import java.util.Set;

@RestController
@RequestMapping("/HotelBookings/events")
public class HotelController {

    @Autowired
    private HotelServiceImpl service;

    @GetMapping("/create/{hotelName}")
    public @ResponseBody
    Hotel create(@PathVariable String hotelName){
        Hotel hotel = HotelFactory.chooseHotel("Cape Town ", 8000, "Cape Sun Hotel", "23 Strand St",
                "021 488 5100", "https://southern-sun-cape-sun.capetown-hotels-za.com/en/");
        return service.create(hotel);

    }
    @GetMapping("/getall")
    @ResponseBody
    public Set<Hotel> getAll(){
        return service.getAll();
    }
}
