package za.ac.cput.Factory;


import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.Domain.Payment.DebitCard;
import za.ac.cput.Factory.DebitCardFactory;

public class DebitCardFactoryTest {

    @Test
    public void debit(){

        DebitCard dbt = DebitCardFactory.dbtCard(1500.00);

        Assert.assertEquals(1500.00, dbt.getDeductions());
    }

}