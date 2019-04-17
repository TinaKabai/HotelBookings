package za.ac.cput.Factory;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.Domain.Content.Guest;

public class GuestFactoryTest extends TestCase {

    @Test
    public void guest(){
        String name; int number; String address;

        Guest guest = GuestFactory.findGuest("Sebe", 731906340, "10 Dorset Street");
        Assert.assertEquals(guest.getName(), guest.getNumber());
    }

}