package za.ac.cput.Factory;

import org.junit.Assert;
import za.ac.cput.Domain.Content.Suite;

public class SuiteFactoryTest {

    public void suite(){

        Suite s = SuiteFactory.suite(true);

        Assert.assertEquals(true, s.isSuite());
    }
}