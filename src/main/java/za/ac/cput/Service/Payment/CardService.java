package za.ac.cput.Service.Payment;

import za.ac.cput.Domain.Payment.Card;
import za.ac.cput.Service.GenIService;

import java.util.List;
import java.util.Map;

public interface CardService extends GenIService<Card, String> {

    Card retrieveById(String id);
    List<Card> getAll();
}
