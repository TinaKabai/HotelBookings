package za.ac.cput.Factory;

import za.ac.cput.Domain.Payment.CreditCard;

public class CreditCardFactory {

    public static CreditCard cdtCard(double credits){
        return new CreditCard.Builder().credit(credits).build();
    }
}
