package za.ac.cput.Service;

import za.ac.cput.Domain.Payment.CreditCard;

import java.util.Map;

public interface CreditCardService extends IService<CreditCard, String> {

    Map<CreditCard, CreditCard> getAll();
}
