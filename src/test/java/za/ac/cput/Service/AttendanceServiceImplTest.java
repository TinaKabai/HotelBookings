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
import za.ac.cput.Domain.Tour.Attendance;
import za.ac.cput.Factory.AttendanceFactory;
import za.ac.cput.Service.Tour.implementations.AttendanceServiceImpl;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class AttendanceServiceImplTest {

    @Autowired
    private AttendanceServiceImpl service;
    private List<Attendance> classes;
    Attendance al;
    Attendance a2;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void create() {
        al = AttendanceFactory.attendingGuests(true);
        Attendance a = this.service.create(al);
        Assert.assertEquals(al.isAttending(), a.isAttending());
    }

    @Test
    public void read() {
        String s = "true";
        Attendance al = this.service.read(s);

        Assert.assertEquals(s, al.isAttending());
        System.out.println(al.isAttending() + " " + al.isAttending());
    }

    @Test
    public void update() {
        al = AttendanceFactory.attendingGuests(true);
        Attendance a = this.service.update(al);
        Assert.assertEquals(al.isAttending(), a.isAttending());
        System.out.println(a.isAttending());
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