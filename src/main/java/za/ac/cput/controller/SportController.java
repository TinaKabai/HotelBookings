package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.Activites.Sport;
import za.ac.cput.Factory.SportFactory;
import za.ac.cput.Service.impl.SportServiceImpl;

import java.util.Set;

@RestController
@RequestMapping("/HotelBookings/sport")
public class SportController {

    @Autowired
    private SportServiceImpl service;

    @GetMapping("/create/{sportName}")
    public @ResponseBody
    Sport create(@PathVariable String sportName){
        Sport sport = SportFactory.findSport("Rugby",
                "Tina", 30, "Cape Sun Hotel");
        return service.create(sport);

    }
    @GetMapping("/getall")
    @ResponseBody
    public Set<Sport> getAll(){
        return service.getAll();
    }

}
