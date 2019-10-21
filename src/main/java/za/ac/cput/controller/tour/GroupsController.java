package za.ac.cput.controller.tour;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.Tour.Groups;
import za.ac.cput.Service.Tour.GroupsService;

import java.util.List;

@RestController
@RequestMapping("/tour groups")
public class GroupsController {

    @Autowired
    private GroupsService service;

    @PostMapping("/create")
    @ResponseBody
    public Groups create(@RequestBody Groups groups) {
        return service.create(groups);
    }

    @GetMapping("/read/{s}")
    @ResponseBody
    public Groups read(@PathVariable String s) {
        return service.read(s);
    }

    @PostMapping("/update")
    @ResponseBody
    public Groups update(@RequestBody Groups groups) {
        return service.update(groups);
    }

    @GetMapping("/delete/{s}")
    @ResponseBody
    public void delete(@PathVariable String s) {
        service.delete(s);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public List<Groups> getAll() {
        return (List<Groups>) service.getAll();
    }
}
