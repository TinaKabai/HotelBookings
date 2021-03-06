package za.ac.cput.Factory;

import za.ac.cput.Domain.Payment.Cash;

public class CashFactory {

    public static Cash cash(String amount, double change){
        return new Cash.Builder().amount(amount).change(change).build();
    }
}
