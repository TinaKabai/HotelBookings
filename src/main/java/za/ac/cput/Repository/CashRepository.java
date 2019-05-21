package za.ac.cput.Repository;

import za.ac.cput.Domain.Payment.Cash;

import java.util.Map;

public interface CashRepository extends IRepository<Cash, String> {

    Map<Cash, Cash> getAll();
}
