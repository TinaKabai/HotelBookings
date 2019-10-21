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
import za.ac.cput.Domain.Payment.Cash;
import za.ac.cput.Factory.CashFactory;
import za.ac.cput.Repository.payment.CashRepository;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class CashRepositoryImplTest {

    @Autowired
    private CashRepository classRepository;
    private List<Cash> classes;
    Cash cl;
    Cash c2;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void create()
    {
        cl = CashFactory.cash("500.00", 10.00);
        c2 = CashFactory.cash("600.00", 20.00);
        Cash c = this.classRepository.save(cl);
        Assert.assertEquals(cl.getAmount(), c.getAmount());
        Cash cc = this.classRepository.save(c2);
        Assert.assertEquals(c2.getAmount(), cc.getAmount());
    }

    @Test
    public void read()
    {
        String s = "500.00";
        Cash c1 = this.classRepository.findById(s).orElse(null);

        Assert.assertEquals(s, c1.getAmount());
        System.out.println(c1.getAmount() + " " + c1.getChange());
    }

    @Test
    public void update()
    {
        cl = CashFactory.cash("500.00", 10.00);
        Cash c = this.classRepository.save(cl);
        Assert.assertEquals(cl.getAmount(), c.getAmount());
        System.out.println(c.getAmount() + "\n" + c.getChange());
    }

    @Test
    public void delete()
    {
        String s = "500.00";
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