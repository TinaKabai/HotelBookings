package za.ac.cput.controller.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.Users.Register;
import za.ac.cput.Service.Users.RegisterService;

import java.util.List;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private RegisterService service;

    @PostMapping("/create")
    @ResponseBody
    public Register create(@RequestBody Register register) {
        return service.create(register);
    }

    @GetMapping("/read/{s}")
    @ResponseBody
    public Register read(@PathVariable String s) {
        return service.read(s);
    }

    @PostMapping("/update")
    @ResponseBody
    public Register update(@RequestBody Register register) {
        return service.update(register);
    }

    @GetMapping("/delete/{s}")
    @ResponseBody
    public void delete(@PathVariable String s) {
        service.delete(s);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public List<Register> getAll() {
        return (List<Register>) service.getAll();
    }
}
