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
import za.ac.cput.Domain.Content.Deluxe;
import za.ac.cput.Factory.DeluxeFactory;
import za.ac.cput.Service.Content.implementations.DeluxeServiceImpl;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class DeluxeServiceImplTest {

    @Autowired
    private DeluxeServiceImpl service;
    private List<Deluxe> classes;
    Deluxe dl;
    Deluxe d2;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void create() {
        dl = DeluxeFactory.delux(true);
        Deluxe d = this.service.create(dl);
        Assert.assertEquals(dl.isDeluxe(), d.isDeluxe());
    }

    @Test
    public void read() {
        String s = "true";
        Deluxe dl = this.service.read(s);

        Assert.assertEquals(s, dl.isDeluxe());
        System.out.println(dl.isDeluxe());
    }

    @Test
    public void update() {
        dl = DeluxeFactory.delux(true);
        Deluxe d = this.service.update(dl);
        Assert.assertEquals(dl.isDeluxe(), d.isDeluxe());
        System.out.println(d.isDeluxe());
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