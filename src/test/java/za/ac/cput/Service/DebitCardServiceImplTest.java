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
import za.ac.cput.Domain.Payment.DebitCard;
import za.ac.cput.Factory.DebitCardFactory;
import za.ac.cput.Service.Payment.implementations.DebitCardServiceImpl;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class DebitCardServiceImplTest {

    @Autowired
    private DebitCardServiceImpl service;
    private List<DebitCard> classes;
    DebitCard dcl;
    DebitCard dc2;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void create() {
        dcl = DebitCardFactory.dbtCard(2000.00);
        DebitCard dc = this.service.create(dcl);
        Assert.assertSame(dcl.getDeductions(), dc.getDeductions());
    }

    @Test
    public void read() {
        String s = "2000.00";
        DebitCard dcl = this.service.read(s);

        Assert.assertEquals(s, dcl.getDeductions());
        System.out.println(dcl.getDeductions());
    }

    @Test
    public void update() {
        dcl = DebitCardFactory.dbtCard(2000.00);
        DebitCard dc = this.service.update(dcl);
        Assert.assertEquals(dcl.getDeductions(), dc.getDeductions());
        System.out.println(dc.getDeductions());
    }

    @Test
    public void delete() {
        String s = "2000.00";
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