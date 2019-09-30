package za.ac.cput.Repository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import za.ac.cput.Domain.Content.Booking;
import za.ac.cput.Factory.BookingFactory;
import za.ac.cput.Repository.Implementation.BookingRepositoryImpl;

import java.util.Map;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class BookingRepositoryImplTest {

    private BookingRepository repository;

    private Booking booking;

    @Before
    public void setUp() throws Exception {

        this.repository = (BookingRepositoryImpl) BookingRepositoryImpl.getRepository();

        this.booking = BookingFactory.bookings(true);
    }

    @Test
    public void d_getAll() {
        Map<Booking, Booking> admin = this.repository.getAll();

        System.out.println("In getAll, all = " + admin);
    }

    @Test
    public void create() {

        Booking created = this.repository.create(this.booking);

        System.out.println("In create, created = " + created);

        Assert.assertNotNull(created);

        Assert.assertSame(created, this.booking);
    }

    @Test
    public void read() {

        Booking read = this.repository.read(booking.getName());

        System.out.println("In read, read = " + read);

        d_getAll();
        Assert.assertEquals(read, booking);
    }

    @Test
    public void update() {

        boolean newABooking = true;

        Booking updated = new Booking.Builder().pay(newABooking).build();

        System.out.println("In update, about_to_updated = " + updated);

        this.repository.update(updated);

        Assert.assertEquals(newABooking, updated.isPay());
        d_getAll();
    }

    @Test
    public void delete() {

        this.repository.delete(booking.getName());
        d_getAll();
    }
}