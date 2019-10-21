package za.ac.cput.controller.activities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.Activites.Event;
import za.ac.cput.Factory.EventFactory;
import za.ac.cput.Service.Activities.EventService;
import za.ac.cput.Service.Activities.implementations.EventServiceImpl;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService service;

    @PostMapping("/create")
    @ResponseBody
    public Event create(@RequestBody Event event) {
        return service.create(event);
    }

    @GetMapping("/read/{s}")
    @ResponseBody
    public Event read(@PathVariable String s) {
        return service.read(s);
    }

    @PostMapping("/update")
    @ResponseBody
    public Event update(@RequestBody Event event) {
        return service.update(event);
    }

    @GetMapping("/delete/{s}")
    @ResponseBody
    public void delete(@PathVariable String s) {
        service.delete(s);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public List<Event> getAll() {
        return (List<Event>) service.getAll();
    }
}
