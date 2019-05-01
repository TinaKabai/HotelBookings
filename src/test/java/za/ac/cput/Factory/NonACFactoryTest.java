package za.ac.cput.Factory;


import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.Domain.Content.NonAC;
import za.ac.cput.Factory.NonACFactory;

public class NonACFactoryTest {

    @Test
    public void nonAC(){

        NonAC non = NonACFactory.accessibility(true);

        Assert.assertEquals(true, non.isNonAC());
    }


}