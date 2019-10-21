package za.ac.cput.Service.Payment;

import za.ac.cput.Domain.Payment.Cash;
import za.ac.cput.Service.GenIService;

import java.util.List;
import java.util.Map;

public interface CashService extends GenIService<Cash, String> {

    Cash retrieveById(String id);
    List<Cash> getAll();
}
