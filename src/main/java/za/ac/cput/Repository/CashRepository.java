package za.ac.cput.Repository;

import za.ac.cput.Domain.Payment.Cash;

import java.util.Set;

public interface CashRepository extends IRepository<Cash, String> {

    Set<Cash> getAll();
}
