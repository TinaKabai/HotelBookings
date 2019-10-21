package za.ac.cput.controller.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.Payment.Cash;
import za.ac.cput.Service.Payment.CashService;

import java.util.List;

@RestController
@RequestMapping("/cash payment")
public class CashController {

    @Autowired
    private CashService service;

    @PostMapping("/create")
    @ResponseBody
    public Cash create(@RequestBody Cash cash) {
        return service.create(cash);
    }

    @GetMapping("/read/{s}")
    @ResponseBody
    public Cash read(@PathVariable String s) {
        return service.read(s);
    }

    @PostMapping("/update")
    @ResponseBody
    public Cash update(@RequestBody Cash cash) {
        return service.update(cash);
    }

    @GetMapping("/delete/{s}")
    @ResponseBody
    public void delete(@PathVariable String s) {
        service.delete(s);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public List<Cash> getAll() {
        return (List<Cash>) service.getAll();
    }
}
