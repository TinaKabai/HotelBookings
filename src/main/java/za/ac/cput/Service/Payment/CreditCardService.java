package za.ac.cput.Service.Payment;

import za.ac.cput.Domain.Payment.CreditCard;
import za.ac.cput.Service.GenIService;

import java.util.List;
import java.util.Map;

public interface CreditCardService extends GenIService<CreditCard, String> {

    CreditCard retrieveById(String id);
    List<CreditCard> getAll();
}
