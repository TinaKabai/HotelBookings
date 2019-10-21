package za.ac.cput.controller.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.Users.Login;
import za.ac.cput.Service.Users.LoginService;

import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService service;

    @PostMapping("/create")
    @ResponseBody
    public Login create(@RequestBody Login login) {
        return service.create(login);
    }

    @GetMapping("/read/{s}")
    @ResponseBody
    public Login read(@PathVariable String s) {
        return service.read(s);
    }

    @PostMapping("/update")
    @ResponseBody
    public Login update(@RequestBody Login login) {
        return service.update(login);
    }

    @GetMapping("/delete/{s}")
    @ResponseBody
    public void delete(@PathVariable String s) {
        service.delete(s);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public List<Login> getAll() {
        return (List<Login>) service.getAll();
    }
}
