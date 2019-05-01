package za.ac.cput.Repository;

import za.ac.cput.Domain.Payment.CreditCard;

import java.util.Set;

public interface CreditCardRepository extends IRepository<CreditCard, String> {

    Set<CreditCard> getAll();
}
