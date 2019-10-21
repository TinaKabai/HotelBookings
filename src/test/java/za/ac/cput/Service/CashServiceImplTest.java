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
import za.ac.cput.Domain.Payment.Cash;
import za.ac.cput.Factory.CashFactory;
import za.ac.cput.Service.Payment.implementations.CashServiceImpl;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class CashServiceImplTest {

    @Autowired
    private CashServiceImpl service;
    private List<Cash> classes;
    Cash cl;
    Cash c2;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void create() {
        cl = CashFactory.cash("500.00", 10.00);
        Cash c = this.service.create(cl);
        Assert.assertEquals(cl.getAmount(), c.getAmount());
    }

    @Test
    public void read() {
        String s = "500.00";
        Cash cl = this.service.read(s);

        Assert.assertEquals(s, cl.getAmount());
        System.out.println(cl.getAmount() + " " + cl.getChange());
    }

    @Test
    public void update() {
        cl = CashFactory.cash("500.00", 10.00);
        Cash c = this.service.update(cl);
        Assert.assertEquals(cl.getAmount(), c.getAmount());
        System.out.println(c.getAmount() + "\n" + c.getChange());
    }

    @Test
    public void delete() {
        String s = "500.00";
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