package za.ac.cput.controller.content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.Content.Room;
import za.ac.cput.Service.Content.RoomService;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomService service;

    @PostMapping("/create")
    @ResponseBody
    public Room create(@RequestBody Room room) {
        return service.create(room);
    }

    @GetMapping("/read/{s}")
    @ResponseBody
    public Room read(@PathVariable String s) {
        return service.read(s);
    }

    @PostMapping("/update")
    @ResponseBody
    public Room update(@RequestBody Room room) {
        return service.update(room);
    }

    @GetMapping("/delete/{s}")
    @ResponseBody
    public void delete(@PathVariable String s) {
        service.delete(s);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public List<Room> getAll() {
        return (List<Room>) service.getAll();
    }
}
