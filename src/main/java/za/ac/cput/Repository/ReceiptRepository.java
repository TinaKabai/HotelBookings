package za.ac.cput.Repository;

import za.ac.cput.Domain.Payment.Receipt;

import java.util.Set;

public interface ReceiptRepository extends IRepository<Receipt, String> {

    Set<Receipt> getAll();
}
