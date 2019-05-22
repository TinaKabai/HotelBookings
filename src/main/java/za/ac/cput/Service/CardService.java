package za.ac.cput.Service;

import za.ac.cput.Domain.Payment.Card;

import java.util.Map;

public interface CardService extends IService<Card, String> {

    Map<Card, Card> getAll();
}
