package za.ac.cput.controller.content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.Content.Demographic;
import za.ac.cput.Factory.DemographicFactory;
import za.ac.cput.Service.Content.DemographicService;
import za.ac.cput.Service.Content.implementations.DemographicServiceImpl;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/demographic")
public class DemographicController {

    @Autowired
    private DemographicService service;

    @PostMapping("/create")
    @ResponseBody
    public Demographic create(@RequestBody Demographic demographic) {
        return service.create(demographic);
    }

    @GetMapping("/read/{s}")
    @ResponseBody
    public Demographic read(@PathVariable String s) {
        return service.read(s);
    }

    @PostMapping("/update")
    @ResponseBody
    public Demographic update(@RequestBody Demographic demographic) {
        return service.update(demographic);
    }

    @GetMapping("/delete/{s}")
    @ResponseBody
    public void delete(@PathVariable String s) {
        service.delete(s);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public List<Demographic> getAll() {
        return (List<Demographic>) service.getAll();
    }
}
