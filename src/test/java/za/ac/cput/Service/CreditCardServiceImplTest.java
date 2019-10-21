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
import za.ac.cput.Domain.Payment.CreditCard;
import za.ac.cput.Factory.CreditCardFactory;
import za.ac.cput.Service.Payment.implementations.CreditCardServiceImpl;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class CreditCardServiceImplTest {

    @Autowired
    private CreditCardServiceImpl service;
    private List<CreditCard> classes;
    CreditCard ccl;
    CreditCard cc2;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void create() {
        ccl = CreditCardFactory.cdtCard(5000.00);
        CreditCard cc = this.service.create(ccl);
        Assert.assertSame(ccl.getCredits(), cc.getCredits());
    }

    @Test
    public void read() {
        String s = "5000.00";
        CreditCard ccl = this.service.read(s);

        Assert.assertEquals(s, ccl.getCredits());
        System.out.println(ccl.getCredits());
    }

    @Test
    public void update() {
        ccl = CreditCardFactory.cdtCard(5000.00);
        CreditCard cc = this.service.update(ccl);
        Assert.assertSame(ccl.getCredits(), cc.getCredits());
        System.out.println(cc.getCredits());
    }

    @Test
    public void delete() {
        String s = "5000.00";
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