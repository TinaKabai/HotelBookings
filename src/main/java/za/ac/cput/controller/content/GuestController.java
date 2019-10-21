package za.ac.cput.controller.content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.Content.Guest;
import za.ac.cput.Factory.GuestFactory;
import za.ac.cput.Service.Content.GuestService;
import za.ac.cput.Service.Content.implementations.GuestServiceImpl;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/guests")
public class GuestController {

    @Autowired
    private GuestService service;

    @PostMapping("/create")
    @ResponseBody
    public Guest create(@RequestBody Guest guest) {
        return service.create(guest);
    }

    @GetMapping("/read/{s}")
    @ResponseBody
    public Guest read(@PathVariable String s) {
        return service.read(s);
    }

    @PostMapping("/update")
    @ResponseBody
    public Guest update(@RequestBody Guest guest) {
        return service.update(guest);
    }

    @GetMapping("/delete/{s}")
    @ResponseBody
    public void delete(@PathVariable String s) {
        service.delete(s);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public List<Guest> getAll() {
        return (List<Guest>) service.getAll();
    }
}
