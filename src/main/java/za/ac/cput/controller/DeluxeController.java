package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.Content.Deluxe;
import za.ac.cput.Factory.DeluxeFactory;
import za.ac.cput.Service.impl.DeluxeServiceImpl;

import java.util.Map;

@RestController
@RequestMapping("/HotelBookings/deluxe")
public class DeluxeController {

    @Autowired
    private DeluxeServiceImpl service;

    @GetMapping("/create/{hotelType}")
    public @ResponseBody
    Deluxe create(@PathVariable String hotelType){
        Deluxe deluxe = DeluxeFactory.delux(true);
        return service.create(deluxe);

    }
    @GetMapping("/getall")
    @ResponseBody
    public Map<Deluxe, Deluxe> getAll(){
        return service.getAll();
    }
}
