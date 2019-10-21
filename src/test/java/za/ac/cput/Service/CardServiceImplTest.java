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
import za.ac.cput.Domain.Payment.Card;
import za.ac.cput.Factory.CardFactory;
import za.ac.cput.Service.Payment.implementations.CardServiceImpl;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class CardServiceImplTest {

    @Autowired
    private CardServiceImpl service;
    private List<Card> classes;
    Card cl;
    Card c2;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void create() {
        cl = CardFactory.guestCard("6008158300567190", 6991);
        Card c = this.service.create(cl);
        Assert.assertEquals(cl.getCardNo(), c.getCardNo());
    }

    @Test
    public void read() {
        String s = "6008158300567190";
        Card cl = this.service.read(s);

        Assert.assertEquals(s, cl.getCardNo());
        System.out.println(cl.getCardNo() + " " + cl.getPin());
    }

    @Test
    public void update() {
        cl = CardFactory.guestCard("6008158300567190", 6991);
        Card c = this.service.update(cl);
        Assert.assertEquals(cl.getCardNo(), c.getCardNo());
        System.out.println(c.getCardNo() + "\n" + c.getPin());
    }

    @Test
    public void delete() {
        String s = "6008158300567190";
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