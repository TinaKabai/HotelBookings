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
import za.ac.cput.Domain.Payment.Card;
import za.ac.cput.Factory.CardFactory;
import za.ac.cput.Repository.payment.CardRepository;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class CardRepositoryImplTest {

    @Autowired
    private CardRepository classRepository;
    private List<Card> classes;
    Card cl;
    Card c2;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void create()
    {
        cl = CardFactory.guestCard("6008158300567190", 6991);
        c2 = CardFactory.guestCard("6008158300567188", 8991);
        Card c = this.classRepository.save(cl);
        Assert.assertEquals(cl.getCardNo(), c.getCardNo());
        Card cc = this.classRepository.save(c2);
        Assert.assertEquals(c2.getCardNo(), cc.getCardNo());
    }

    @Test
    public void read()
    {
        String s = "6008158300567190";
        Card c1 = this.classRepository.findById(s).orElse(null);

        Assert.assertEquals(s, c1.getCardNo());
        System.out.println(c1.getCardNo() + " " + c1.getPin());
    }

    @Test
    public void update()
    {
        cl = CardFactory.guestCard("6008158300567190", 6991);
        Card c = this.classRepository.save(cl);
        Assert.assertEquals(cl.getCardNo(), c.getCardNo());
        System.out.println(c.getCardNo() + "\n" + c.getPin());
    }

    @Test
    public void delete()
    {
        String s = "6008158300567190";
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