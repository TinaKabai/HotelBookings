package za.ac.cput.controller.tour;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.Tour.Attendance;
import za.ac.cput.Service.Tour.AttendanceService;

import java.util.List;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService service;

    @PostMapping("/create")
    @ResponseBody
    public Attendance create(@RequestBody Attendance attendance) {
        return service.create(attendance);
    }

    @GetMapping("/read/{s}")
    @ResponseBody
    public Attendance read(@PathVariable String s) {
        return service.read(s);
    }

    @PostMapping("/update")
    @ResponseBody
    public Attendance update(@RequestBody Attendance attendance) {
        return service.update(attendance);
    }

    @GetMapping("/delete/{s}")
    @ResponseBody
    public void delete(@PathVariable String s) {
        service.delete(s);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public List<Attendance> getAll() {
        return (List<Attendance>) service.getAll();
    }
}
