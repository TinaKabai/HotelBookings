package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.Content.Demographic;
import za.ac.cput.Factory.DemographicFactory;
import za.ac.cput.Service.impl.DemographicServiceImpl;

import java.util.Map;

@RestController
@RequestMapping("/HotelBookings/demographic")
public class DemographicController {

    @Autowired
    private DemographicServiceImpl service;

    @GetMapping("/create/{race}")
    public @ResponseBody
    Demographic create(@PathVariable String demographic){
        Demographic demographics = DemographicFactory.identifyDemo("Black", " Sotho ", 16, " Male");
        return service.create(demographics);

    }
    @GetMapping("/getall")
    @ResponseBody
    public Map<Demographic, Demographic> getAll(){
        return service.getAll();
    }
}
