package za.ac.cput.Repository;

import za.ac.cput.Domain.Payment.DebitCard;

import java.util.Set;

public interface DebitCardRepository extends IRepository<DebitCard, String> {

    Set<DebitCard> getAll();
}
