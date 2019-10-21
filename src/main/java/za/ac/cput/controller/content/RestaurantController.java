package za.ac.cput.controller.content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.Content.Restaurant;
import za.ac.cput.Service.Content.RestaurantService;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService service;

    @PostMapping("/create")
    @ResponseBody
    public Restaurant create(@RequestBody Restaurant restaurant) {
        return service.create(restaurant);
    }

    @GetMapping("/read/{s}")
    @ResponseBody
    public Restaurant read(@PathVariable String s) {
        return service.read(s);
    }

    @PostMapping("/update")
    @ResponseBody
    public Restaurant update(@RequestBody Restaurant restaurant) {
        return service.update(restaurant);
    }

    @GetMapping("/delete/{s}")
    @ResponseBody
    public void delete(@PathVariable String s) {
        service.delete(s);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public List<Restaurant> getAll() {
        return (List<Restaurant>) service.getAll();
    }
}
