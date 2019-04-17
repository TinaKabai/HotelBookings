package za.ac.cput.Factory;

import za.ac.cput.Domain.Payment.DebitCard;

public class DebitCardFactory {
    public static DebitCard dbtCard(double deductions){
        return new DebitCard.Builder().deduction(deductions).build();
    }
}
