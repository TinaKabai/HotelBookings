package za.ac.cput.Factory;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.Domain.Tour.TourGuide;

public class TourGuideFactoryTest {

    @Test
    public void Tour(){

        TourGuide tg = TourGuideFactory.guide("Bongeka", true);

        Assert.assertEquals(true, tg.isAvailable());
    }

}