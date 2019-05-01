package za.ac.cput.Factory;


import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.Domain.Content.Booking;
import za.ac.cput.Factory.BookingFactory;

public class BookingFactoryTest {

    @Test

    public void booking(){
        Booking book = BookingFactory.bookings(true);

        Assert.assertEquals(true, book.isPay());
    }
}