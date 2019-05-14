package za.ac.cput.Factory;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.Domain.Content.Suite;

public class SuiteFactoryTest {

    @Test
    public void suites(){

        Suite suit = SuiteFactory.suites(true);

        Assert.assertEquals(true, suit.isSuite());
    }

}