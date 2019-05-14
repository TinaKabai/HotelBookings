package za.ac.cput.Factory;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.Domain.Activites.Sport;

public class SportFactoryTest {

@Test
    public void sports(){

        Sport sport = SportFactory.findSport("Rugby",
                "Tina", 30, "Cape Sun Hotel");

        Assert.assertEquals("Rugby", sport.getSportName());
    }

}