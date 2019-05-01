package za.ac.cput.Repository;

import za.ac.cput.Domain.Payment.Card;

import java.util.Set;

public interface CardRepository extends IRepository<Card, String> {

    Set<Card> getAll();
}
