package za.ac.cput.Factory;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.Domain.Content.Restaurant;
import za.ac.cput.Factory.RestaurantFactory;

public class RestaurantFactoryTest {

    @Test
    public void restaurant(){

        Restaurant r = RestaurantFactory.findRestaurant("Riempies Restaurant", 8, "Main");

        Assert.assertEquals("Riempies Restaurant, 8 Main", "Riempies Restaurant", r.getRestuName());
    }
}