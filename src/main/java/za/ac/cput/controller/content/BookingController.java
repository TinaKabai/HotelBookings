package za.ac.cput.controller.content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.Content.Booking;
import za.ac.cput.Service.Content.BookingService;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService service;

    @PostMapping("/create")
    @ResponseBody
    public Booking create(@RequestBody Booking booking) {
        return service.create(booking);
    }

    @GetMapping("/read/{s}")
    @ResponseBody
    public Booking read(@PathVariable String s) {
        return service.read(s);
    }

    @PostMapping("/update")
    @ResponseBody
    public Booking update(@RequestBody Booking booking) {
        return service.update(booking);
    }

    @GetMapping("/delete/{s}")
    @ResponseBody
    public void delete(@PathVariable String s) {
        service.delete(s);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public List<Booking> getAll() {
        return (List<Booking>) service.getAll();
    }
}
