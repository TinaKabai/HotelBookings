package za.ac.cput.controller.content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.Content.Deluxe;
import za.ac.cput.Factory.DeluxeFactory;
import za.ac.cput.Service.Content.DeluxeService;
import za.ac.cput.Service.Content.implementations.DeluxeServiceImpl;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/deluxe rooms")
public class DeluxeController {

    @Autowired
    private DeluxeService service;

    @PostMapping("/create")
    @ResponseBody
    public Deluxe create(@RequestBody Deluxe deluxe) {
        return service.create(deluxe);
    }

    @GetMapping("/read/{s}")
    @ResponseBody
    public Deluxe read(@PathVariable String s) {
        return service.read(s);
    }

    @PostMapping("/update")
    @ResponseBody
    public Deluxe update(@RequestBody Deluxe deluxe) {
        return service.update(deluxe);
    }

    @GetMapping("/delete/{s}")
    @ResponseBody
    public void delete(@PathVariable String s) {
        service.delete(s);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public List<Deluxe> getAll() {
        return (List<Deluxe>) service.getAll();
    }
}
