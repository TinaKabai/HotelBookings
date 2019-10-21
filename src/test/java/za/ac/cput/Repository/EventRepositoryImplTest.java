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
import za.ac.cput.Domain.Activites.Event;
import za.ac.cput.Factory.EventFactory;
import za.ac.cput.Repository.activities.EventRepository;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class EventRepositoryImplTest {

    @Autowired
    private EventRepository classRepository;
    private List<Event> classes;
    Event el;
    Event e2;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void create() {
        el = EventFactory.events("Athletics", "All_Suites Peninsula Hotel","10 May 2019",
                                    150.00);
        e2 = EventFactory.events("Music Festival", "Cape Suns Hotel","18 September 2019",
                                    200.00);
        Event e = this.classRepository.save(el);
        Assert.assertEquals(el.getEvName(), e.getEvName());
        Event ee = this.classRepository.save(e2);
        Assert.assertEquals(e2.getEvName(), ee.getEvName());
    }

    @Test
    public void read()
    {
        String s = "Athletics";
        Event e1 = this.classRepository.findById(s).orElse(null);

        Assert.assertEquals(s, e1.getEvName());
        System.out.println(e1.getEvName());
    }

    @Test
    public void update()
    {
        el = EventFactory.events("Athletics", "All_Suites Peninsula Hotel","10 May 2019",
                                    150.00);
        Event e = this.classRepository.save(el);
        Assert.assertEquals(el.getEvName(), e.getEvName());
        System.out.println(e.getEvName());
    }

    @Test
    public void delete()
    {
        String s = "Athletics";
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