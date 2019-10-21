package za.ac.cput.controller.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.Payment.Receipt;
import za.ac.cput.Service.Payment.ReceiptService;

import java.util.List;

@RestController
@RequestMapping("/payment receipt")
public class ReceiptController {

    @Autowired
    private ReceiptService service;

    @PostMapping("/create")
    @ResponseBody
    public Receipt create(@RequestBody Receipt receipt) {
        return service.create(receipt);
    }

    @GetMapping("/read/{s}")
    @ResponseBody
    public Receipt read(@PathVariable String s) {
        return service.read(s);
    }

    @PostMapping("/update")
    @ResponseBody
    public Receipt update(@RequestBody Receipt receipt) {
        return service.update(receipt);
    }

    @GetMapping("/delete/{s}")
    @ResponseBody
    public void delete(@PathVariable String s) {
        service.delete(s);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public List<Receipt> getAll() {
        return (List<Receipt>) service.getAll();
    }
}
