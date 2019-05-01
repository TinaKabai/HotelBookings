package za.ac.cput.Factory;


import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.Domain.Activites.Event;
import za.ac.cput.Factory.EventFactory;

public class EventFactoryTest {

    @Test
    public void event(){

        Event e = EventFactory.events("Rugby", "Cape Sun Hotel", "10 May 2019", 100.00);

        Assert.assertEquals("10 May 2019", e.getDate());
    }
}