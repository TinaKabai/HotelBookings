package za.ac.cput.Factory;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.Domain.Content.Demographic;
import za.ac.cput.Factory.DemographicFactory;

public class DemographicFactoryTest {

    @Test
    public void demo(){

        Demographic graphic = DemographicFactory.identifyDemo("Black", " Sotho", 16, " Male");

        Assert.assertEquals("Black", graphic.getRace());
    }

}