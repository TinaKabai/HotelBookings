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
import za.ac.cput.Domain.Content.Suite;
import za.ac.cput.Factory.SuiteFactory;
import za.ac.cput.Service.Content.implementations.SuiteServiceImpl;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class SuiteServiceImplTest {

    @Autowired
    private SuiteServiceImpl service;
    private List<Suite> classes;
    Suite sl;
    Suite s2;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void create() {
        sl = SuiteFactory.suites(true);
        Suite s = this.service.create(sl);
        Assert.assertEquals(sl.isSuite(), s.isSuite());
    }

    @Test
    public void read() {
        String s = "true";
        Suite sl = this.service.read(s);

        Assert.assertEquals(s, sl.isSuite());
        System.out.println(sl.isSuite());
    }

    @Test
    public void update() {
        sl = SuiteFactory.suites(true);
        Suite s = this.service.update(sl);
        Assert.assertEquals(sl.isSuite(), s.isSuite());
        System.out.println(s.isSuite());
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