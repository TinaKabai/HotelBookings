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
import za.ac.cput.Domain.Content.NonAC;
import za.ac.cput.Factory.NonACFactory;
import za.ac.cput.Service.Content.implementations.NonACServiceImpl;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class NonACServiceImplTest {

    @Autowired
    private NonACServiceImpl service;
    private List<NonAC> classes;
    NonAC nl;
    NonAC n2;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void create() {
        nl = NonACFactory.accessibility(true);
        NonAC n = this.service.create(nl);
        Assert.assertEquals(nl.isNonAC(), n.isNonAC());
    }

    @Test
    public void read() {
        String s = "true";
        NonAC nl = this.service.read(s);

        Assert.assertEquals(s, nl.isNonAC());
        System.out.println(nl.isNonAC());
    }

    @Test
    public void update() {
        nl = NonACFactory.accessibility(true);
        NonAC n = this.service.update(nl);
        Assert.assertEquals(nl.isNonAC(), n.isNonAC());
        System.out.println(n.isNonAC());
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