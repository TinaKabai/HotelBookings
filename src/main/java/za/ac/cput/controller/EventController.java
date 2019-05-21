package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.Activites.Event;
import za.ac.cput.Factory.EventFactory;
import za.ac.cput.Service.impl.EventServiceImpl;

import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/sms/course")
public class EventController {


        @Autowired
        private EventServiceImpl service;

        @GetMapping("/create/{eventName}")
        public @ResponseBody
        Event create(@PathVariable String eventName){
            Event event = EventFactory.events("Rugby", "Cape Sun Hotel", "10 May 2019", 100.00);
            return service.create(event);

        }
        @GetMapping("/getall")
        @ResponseBody
        public Map<Event, Event> getAll(){
            return service.getAll();
        }
}
