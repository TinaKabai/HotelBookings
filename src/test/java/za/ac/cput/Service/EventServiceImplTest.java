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
import za.ac.cput.Domain.Activites.Event;
import za.ac.cput.Factory.EventFactory;
import za.ac.cput.Service.Activities.implementations.EventServiceImpl;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class EventServiceImplTest {

    @Autowired
    private EventServiceImpl service;
    private List<Event> classes;
    Event el;
    Event e2;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void create() {
        el = EventFactory.events("Athletics", "All_Suites Peninsula Hotel","10 May 2019",150.00);
        Event e = this.service.create(el);
        Assert.assertEquals(el.getEvName(), e.getEvName());
    }

    @Test
    public void read() {
        String s = "Athletics";
        Event el = this.service.read(s);

        Assert.assertEquals(s, el.getEvName());
        System.out.println(el.getEvName() + " " + el.getDate());
    }

    @Test
    public void update() {
        el = EventFactory.events("Athletics", "All_Suites Peninsula Hotel","10 May 2019",150.00);
        Event e = this.service.update(el);
        Assert.assertEquals(el.getEvName(), e.getEvName());
        System.out.println(e.getEvName() + "\n" + e.getDate());
    }

    @Test
    public void delete() {
        String s = "Athletics";
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