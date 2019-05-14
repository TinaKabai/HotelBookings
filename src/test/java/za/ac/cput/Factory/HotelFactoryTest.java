package za.ac.cput.Factory;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.Domain.Content.Hotel;
import za.ac.cput.Factory.HotelFactory;

public class HotelFactoryTest {

@Test
    public void hotel(){

        Hotel hotel = HotelFactory.chooseHotel("Cape Town ", 8000, "Cape Sun Hotel", "23 Strand St",
                "021 488 5100", "https://southern-sun-cape-sun.capetown-hotels-za.com/en/");

        Assert.assertEquals("Cape Sun Hotel", hotel.getHotelName());
    }

}