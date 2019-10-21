package za.ac.cput.controller.activities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.Activites.Sport;
import za.ac.cput.Factory.SportFactory;
import za.ac.cput.Service.Activities.SportService;
import za.ac.cput.Service.Activities.implementations.SportServiceImpl;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("sports")
public class SportController {

    @Autowired
    private SportService service;

    @PostMapping("/create")
    @ResponseBody
    public Sport create(@RequestBody Sport sport) {
        return service.create(sport);
    }

    @GetMapping("/read/{s}")
    @ResponseBody
    public Sport read(@PathVariable String s) {
        return service.read(s);
    }

    @PostMapping("/update")
    @ResponseBody
    public Sport update(@RequestBody Sport sport) {
        return service.update(sport);
    }

    @GetMapping("/delete/{s}")
    @ResponseBody
    public void delete(@PathVariable String s) {
        service.delete(s);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public List<Sport> getAll() {
        return (List<Sport>) service.getAll();
    }
}
