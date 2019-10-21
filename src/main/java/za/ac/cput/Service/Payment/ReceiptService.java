package za.ac.cput.Service.Payment;

import za.ac.cput.Domain.Payment.Receipt;
import za.ac.cput.Service.GenIService;

import java.util.List;
import java.util.Set;

public interface ReceiptService extends GenIService<Receipt, String> {

    Receipt retrieveById(String id);
    List<Receipt> getAll();
}
