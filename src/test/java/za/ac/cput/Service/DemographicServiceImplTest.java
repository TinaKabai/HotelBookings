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
import za.ac.cput.Domain.Content.Demographic;
import za.ac.cput.Factory.DemographicFactory;
import za.ac.cput.Service.Content.implementations.DemographicServiceImpl;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class DemographicServiceImplTest {

    @Autowired
    private DemographicServiceImpl service;
    private List<Demographic> classes;
    Demographic dl;
    Demographic d2;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void create() {
        dl = DemographicFactory.identifyDemo("Black", " Sotho", 16, " Male");
        Demographic d = this.service.create(dl);
        Assert.assertEquals(dl.getGender(), d.getGender());
    }

    @Test
    public void read() {
        String s = "Male";
        Demographic dl = this.service.read(s);

        Assert.assertEquals(s, dl.getGender());
        System.out.println(dl.getGender());
    }

    @Test
    public void update() {
        dl = DemographicFactory.identifyDemo("Black", " Sotho", 16, " Male");
        Demographic d = this.service.update(dl);
        Assert.assertEquals(dl.getGender(), d.getGender());
        System.out.println(d.getGender());
    }

    @Test
    public void delete() {
        String s = "Male";
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