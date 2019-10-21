package za.ac.cput.controller.content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.Content.NonAC;
import za.ac.cput.Service.Content.NonACService;

import java.util.List;

@RestController
@RequestMapping("/Non AC rooms")
public class NonACController {

    @Autowired
    private NonACService service;

    @PostMapping("/create")
    @ResponseBody
    public NonAC create(@RequestBody NonAC nonAC) {
        return service.create(nonAC);
    }

    @GetMapping("/read/{s}")
    @ResponseBody
    public NonAC read(@PathVariable String s) {
        return service.read(s);
    }

    @PostMapping("/update")
    @ResponseBody
    public NonAC update(@RequestBody NonAC nonAC) {
        return service.update(nonAC);
    }

    @GetMapping("/delete/{s}")
    @ResponseBody
    public void delete(@PathVariable String s) {
        service.delete(s);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public List<NonAC> getAll() {
        return (List<NonAC>) service.getAll();
    }
}
