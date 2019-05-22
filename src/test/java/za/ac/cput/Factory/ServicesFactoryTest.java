package za.ac.cput.Factory;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.Domain.Content.Services;

public class ServicesFactoryTest {

@Test
    public void services(){

        Services service = ServicesFactory.chooseService("Room service",
                "Any services in a hotel delivered to a guest directly unto their rooms.", 1000.00);

        Assert.assertEquals("Room service", service.getServName());
    }
}