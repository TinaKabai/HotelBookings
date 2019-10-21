package za.ac.cput.Repository;

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
import za.ac.cput.Repository.content.BookingRepository;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class BookingRepositoryImplTest {

    @Autowired
    private BookingRepository classRepository;
    private List<Booking> classes;
    Booking bl;
    Booking b2;

    @Before
    public void setUp() throws Exception
    {

    }

    @Test
    public void create()
    {
        bl = BookingFactory.bookings(true);
        b2 = BookingFactory.bookings(false);
        Booking b = this.classRepository.save(bl);
        Assert.assertEquals(bl.isPay(), b.isPay());
        Booking bb = this.classRepository.save(b2);
        Assert.assertEquals(b2.isPay(), bb.isPay());
    }

    @Test
    public void read()
    {
        String s = "true";
        Booking b1 = this.classRepository.findById(s).orElse(null);

        Assert.assertEquals(s, b1.isPay());
        System.out.println(b1.isPay());
    }

    @Test
    public void update()
    {
        bl = BookingFactory.bookings(true);
        Booking b = this.classRepository.save(bl);
        Assert.assertEquals(bl.isPay(), b.isPay());
        System.out.println(b.isPay());
    }

    @Test
    public void delete()
    {
        String s = "true";
        this.classRepository.deleteById(s);
        classes = this.classRepository.findAll();
        int size = classes.size();
        Assert.assertEquals(1, size);
    }

    @Test
    public void p_getAll()
    {
        classes = this.classRepository.findAll();
        Assert.assertEquals(1, classes.size());

        System.out.println(classes.size());
    }
}