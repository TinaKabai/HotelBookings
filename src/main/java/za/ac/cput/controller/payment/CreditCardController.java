package za.ac.cput.controller.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.Payment.CreditCard;
import za.ac.cput.Service.Payment.CreditCardService;

import java.util.List;

@RestController
@RequestMapping("creditCard payment")
public class CreditCardController {

    @Autowired
    private CreditCardService service;

    @PostMapping("/create")
    @ResponseBody
    public CreditCard create(@RequestBody CreditCard creditCard) {
        return service.create(creditCard);
    }

    @GetMapping("/read/{s}")
    @ResponseBody
    public CreditCard read(@PathVariable String s) {
        return service.read(s);
    }

    @PostMapping("/update")
    @ResponseBody
    public CreditCard update(@RequestBody CreditCard creditCard) {
        return service.update(creditCard);
    }

    @GetMapping("/delete/{s}")
    @ResponseBody
    public void delete(@PathVariable String s) {
        service.delete(s);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public List<CreditCard> getAll() {
        return (List<CreditCard>) service.getAll();
    }
}
