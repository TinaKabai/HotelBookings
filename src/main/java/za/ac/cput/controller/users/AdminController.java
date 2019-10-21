package za.ac.cput.controller.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.Users.Admin;
import za.ac.cput.Service.Users.AdminService;

import java.util.List;

@RestController
@RequestMapping("/administration")
public class AdminController {
        @Autowired
        private AdminService service;

        @PostMapping("/create")
        @ResponseBody
        public Admin create(@RequestBody Admin admin) {
            return service.create(admin);
        }

        @GetMapping("/read/{s}")
        @ResponseBody
        public Admin read(@PathVariable String s) {
            return service.read(s);
        }

        @PostMapping("/update")
        @ResponseBody
        public Admin update(@RequestBody Admin admin) {
            return service.update(admin);
        }

        @GetMapping("/delete/{s}")
        @ResponseBody
        public void delete(@PathVariable String s) {
            service.delete(s);
        }

        @GetMapping("/getAll")
        @ResponseBody
        public List<Admin> getAll() {
            return (List<Admin>) service.getAll();
        }
}
