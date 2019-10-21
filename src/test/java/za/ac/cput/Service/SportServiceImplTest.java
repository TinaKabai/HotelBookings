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
import za.ac.cput.Domain.Activites.Sport;
import za.ac.cput.Factory.SportFactory;
import za.ac.cput.Service.Activities.implementations.SportServiceImpl;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class SportServiceImplTest {

    @Autowired
    private SportServiceImpl service;
    private List<Sport> classes;
    Sport sl;
    Sport s2;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void create() {
        sl = SportFactory.findSport("Rugby", "Tina", 30, "Cape Sun Hotel");
        Sport s = this.service.create(sl);
        Assert.assertEquals(sl.getSportName(), s.getSportName());
    }

    @Test
    public void read() {
        String s = "Rugby";
        Sport sl = this.service.read(s);

        Assert.assertEquals(s, sl.getSportName());
        System.out.println(sl.getSportName() + " " + sl.getNoParticipants());
    }

    @Test
    public void update() {
        sl = SportFactory.findSport("Rugby", "Tina", 30, "Cape Sun Hotel");
        Sport s = this.service.update(sl);
        Assert.assertEquals(sl.getSportName(), s.getSportName());
        System.out.println(s.getSportName() + "\n" + s.getNoParticipants());
    }

    @Test
    public void delete() {
        String s = "Rugby";
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