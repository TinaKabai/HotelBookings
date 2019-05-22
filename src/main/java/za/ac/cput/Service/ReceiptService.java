package za.ac.cput.Service;

import za.ac.cput.Domain.Payment.Receipt;

import java.util.Set;

public interface ReceiptService extends IService<Receipt, String>{

    Set<Receipt> getAll();
}
