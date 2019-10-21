package za.ac.cput.controller.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.Payment.Card;
import za.ac.cput.Service.Payment.CardService;

import java.util.List;

@RestController
@RequestMapping("/card payment")
public class CardController {

    @Autowired
    private CardService service;

    @PostMapping("/create")
    @ResponseBody
    public Card create(@RequestBody Card card) {
        return service.create(card);
    }

    @GetMapping("/read/{s}")
    @ResponseBody
    public Card read(@PathVariable String s) {
        return service.read(s);
    }

    @PostMapping("/update")
    @ResponseBody
    public Card update(@RequestBody Card card) {
        return service.update(card);
    }

    @GetMapping("/delete/{s}")
    @ResponseBody
    public void delete(@PathVariable String s) {
        service.delete(s);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public List<Card> getAll() {
        return (List<Card>) service.getAll();
    }
}
