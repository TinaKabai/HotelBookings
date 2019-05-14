package za.ac.cput.Factory;


import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.Domain.Payment.Cash;
import za.ac.cput.Factory.CashFactory;

public class CashFactoryTest {
    @Test

    public void cash(){

        Cash c = CashFactory.cash(1000.00, 55.00);

        Assert.assertNotEquals(100.00, c.getAmount());
    }
}