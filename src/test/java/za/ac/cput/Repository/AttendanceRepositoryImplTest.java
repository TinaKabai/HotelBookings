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
import za.ac.cput.Domain.Tour.Attendance;
import za.ac.cput.Factory.AttendanceFactory;
import za.ac.cput.Repository.tour.AttendanceRepository;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class AttendanceRepositoryImplTest{

    @Autowired
    private AttendanceRepository classRepository;
    private List<Attendance> classes;
    Attendance al;
    Attendance a2;

    @Before
    public void setUp() throws Exception
    {

    }

    @Test
    public void create()
    {
        al = AttendanceFactory.attendingGuests(true);
        a2 = AttendanceFactory.attendingGuests(false);
        Attendance a = this.classRepository.save(al);
        Assert.assertEquals(al.isAttending(), a.isAttending());
        Attendance aa = this.classRepository.save(a2);
        Assert.assertEquals(a2.isAttending(), aa.isAttending());
    }

    @Test
    public void m_read()
    {
        String s = "true";
        Attendance a1 = this.classRepository.findById(s).orElse(null);

        Assert.assertEquals(s, al.isAttending());
        System.out.println(a1.isAttending());
    }

    @Test
    public void update()
    {
        al = AttendanceFactory.attendingGuests(true);
        Attendance a = this.classRepository.save(al);
        Assert.assertEquals(al.isAttending(), a.isAttending());
        System.out.println(a.isAttending());
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