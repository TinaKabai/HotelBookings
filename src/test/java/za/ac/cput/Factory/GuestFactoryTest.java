package za.ac.cput.Factory;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.Domain.Content.Guest;
import za.ac.cput.Factory.GuestFactory;

public class GuestFactoryTest {

    @Test
    public void guest(){

        Guest guest = GuestFactory.findGuest("Sebe", "0731906340", "10 Dorset Street");

        Assert.assertEquals("Sebe", guest.getName());
    }
}