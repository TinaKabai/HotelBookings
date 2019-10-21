package za.ac.cput.controller.content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.Content.Services;
import za.ac.cput.Service.Content.ServicesService;
import za.ac.cput.Service.Content.SuiteService;

import java.util.List;

@RestController
@RequestMapping("/suite rooms")
public class SuiteController {

    @Autowired
    private ServicesService service;

    @PostMapping("/create")
    @ResponseBody
    public Services create(@RequestBody Services services) {
        return service.create(services);
    }

    @GetMapping("/read/{s}")
    @ResponseBody
    public Services read(@PathVariable String s) {
        return service.read(s);
    }

    @PostMapping("/update")
    @ResponseBody
    public Services update(@RequestBody Services services) {
        return service.update(services);
    }

    @GetMapping("/delete/{s}")
    @ResponseBody
    public void delete(@PathVariable String s) {
        service.delete(s);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public List<Services> getAll() {
        return (List<Services>) service.getAll();
    }
}
