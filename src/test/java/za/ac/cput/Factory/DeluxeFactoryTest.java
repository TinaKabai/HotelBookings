package za.ac.cput.Factory;


import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.Domain.Content.Deluxe;
import za.ac.cput.Factory.DeluxeFactory;

public class DeluxeFactoryTest {

    @Test
    public void deluxe(){

        Deluxe del = DeluxeFactory.delux(true);

        Assert.assertEquals(true, del.isDeluxe());


    }

}