package za.ac.cput.Service;


import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import za.ac.cput.Domain.Content.Booking;
import za.ac.cput.Factory.BookingFactory;
import za.ac.cput.Service.Content.implementations.BookingServiceImpl;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class BookingServiceImplTest {

    @Autowired
    private BookingServiceImpl service;
    private List<Booking> classes;
    Booking bl;
    Booking b2;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void create() {
        bl = BookingFactory.bookings(true);
        Booking b = this.service.create(bl);
        Assert.assertEquals(bl.isPay(), b.isPay());
    }

    @Test
    public void read() {
        String s = "true";
        Booking bl = this.service.read(s);

        Assert.assertEquals(s, bl.isPay());
        System.out.println(bl.isPay() + " " + bl.isPay());
    }

    @Test
    public void update() {
        bl = BookingFactory.bookings(true);
        Booking b = this.service.update(bl);
        Assert.assertEquals(bl.isPay(), b.isPay());
        System.out.println(b.isPay());
    }

    @Test
    public void delete() {
        String s = "true";
        this.service.delete(s);
        classes = this.service.getAll();
        int size = classes.size();
        System.out.println(size);
        Assert.assertEquals(classes.size(), size);
    }

    @Test
    public void getAll() {
        classes = this.service.getAll();
        System.out.println(classes.size());
        Assert.assertEquals(1, classes.size());
    }
}