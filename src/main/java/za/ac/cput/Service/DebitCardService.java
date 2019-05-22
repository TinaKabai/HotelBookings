package za.ac.cput.Service;

import za.ac.cput.Domain.Payment.DebitCard;

import java.util.Map;

public interface DebitCardService extends IService<DebitCard,String> {

    Map<DebitCard, DebitCard> getAll();
}
