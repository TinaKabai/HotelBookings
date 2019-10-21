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
import za.ac.cput.Domain.Content.Services;
import za.ac.cput.Factory.ServicesFactory;
import za.ac.cput.Service.Content.implementations.ServicesServiceImpl;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ServicesServiceImplTest {

    @Autowired
    private ServicesServiceImpl service;
    private List<Services> classes;
    Services sl;
    Services s2;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void create() {
        sl = ServicesFactory.chooseService("Food service",
                "Any services in a hotel delivered to a guest directly unto their rooms.", 1000.00);
        Services s = this.service.create(sl);
        Assert.assertEquals(sl.getServName(), s.getServName());
    }

    @Test
    public void read() {
        String s = "Food service";
        Services sl = this.service.read(s);

        Assert.assertEquals(s, sl.getServName());
        System.out.println(sl.getServName() + " " + sl.getPrice());
    }

    @Test
    public void update() {
        sl = ServicesFactory.chooseService("Food service",
                "Any services in a hotel delivered to a guest directly unto their rooms.", 1000.00);
        Services s = this.service.update(sl);
        Assert.assertEquals(sl.getServName(), s.getServName());
        System.out.println(s.getServName() + "\n" + s.getPrice());
    }

    @Test
    public void delete() {
        String s = "Food service";
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