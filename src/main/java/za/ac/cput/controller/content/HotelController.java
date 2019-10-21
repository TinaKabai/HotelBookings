package za.ac.cput.controller.content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.Content.Hotel;
import za.ac.cput.Service.Content.HotelService;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService service;

    @PostMapping("/create")
    @ResponseBody
    public Hotel create(@RequestBody Hotel hotel) {
        return service.create(hotel);
    }

    @GetMapping("/read/{s}")
    @ResponseBody
    public Hotel read(@PathVariable String s) {
        return service.read(s);
    }

    @PostMapping("/update")
    @ResponseBody
    public Hotel update(@RequestBody Hotel hotel) {
        return service.update(hotel);
    }

    @GetMapping("/delete/{s}")
    @ResponseBody
    public void delete(@PathVariable String s) {
        service.delete(s);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public List<Hotel> getAll() {
        return (List<Hotel>) service.getAll();
    }
}
