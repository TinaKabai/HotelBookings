package za.ac.cput.Factory;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.Domain.Payment.Receipt;

public class ReceiptFactoryTest{

    @Test
    public void receipt(){

        Receipt receipts = ReceiptFactory.receipt("10 May 2019", "78557888",
                            "78855", "79559456", "7410");

        Assert.assertEquals("79559456", receipts.getPaymentRef());
    }
}