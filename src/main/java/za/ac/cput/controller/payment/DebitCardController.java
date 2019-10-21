package za.ac.cput.controller.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.Payment.DebitCard;
import za.ac.cput.Service.Payment.DebitCardService;

import java.util.List;

@RestController
@RequestMapping("/debitCard payment")
public class DebitCardController {

    @Autowired
    private DebitCardService service;

    @PostMapping("/create")
    @ResponseBody
    public DebitCard create(@RequestBody DebitCard debitCard) {
        return service.create(debitCard);
    }

    @GetMapping("/read/{s}")
    @ResponseBody
    public DebitCard read(@PathVariable String s) {
        return service.read(s);
    }

    @PostMapping("/update")
    @ResponseBody
    public DebitCard update(@RequestBody DebitCard debitCard) {
        return service.update(debitCard);
    }

    @GetMapping("/delete/{s}")
    @ResponseBody
    public void delete(@PathVariable String s) {
        service.delete(s);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public List<DebitCard> getAll() {
        return (List<DebitCard>) service.getAll();
    }
}
