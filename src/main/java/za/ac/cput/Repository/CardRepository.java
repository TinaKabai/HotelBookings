package za.ac.cput.Repository;

import za.ac.cput.Domain.Payment.Card;

import java.util.Map;

public interface CardRepository extends IRepository<Card, String> {

    Map<Card, Card> getAll();
}
