package za.ac.cput.Service.Payment;

import za.ac.cput.Domain.Payment.DebitCard;
import za.ac.cput.Service.GenIService;

import java.util.List;
import java.util.Map;

public interface DebitCardService extends GenIService<DebitCard,String> {

    DebitCard retrieveById(String id);
    List<DebitCard> getAll();
}
