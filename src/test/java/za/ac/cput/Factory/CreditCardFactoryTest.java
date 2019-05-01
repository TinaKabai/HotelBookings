package za.ac.cput.Factory;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.Domain.Payment.CreditCard;
import za.ac.cput.Factory.CreditCardFactory;

public class CreditCardFactoryTest{
    @Test

    public void credit(){

        CreditCard crdt = CreditCardFactory.cdtCard(7.9);

        Assert.assertNotEquals(5.5, crdt.getCredits());
    }
}