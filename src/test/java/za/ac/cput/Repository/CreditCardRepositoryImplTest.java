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
import za.ac.cput.Domain.Payment.CreditCard;
import za.ac.cput.Factory.CreditCardFactory;
import za.ac.cput.Repository.payment.CreditCardRepository;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class CreditCardRepositoryImplTest {

    @Autowired
    private CreditCardRepository classRepository;
    private List<CreditCard> classes;
    CreditCard ccl;
    CreditCard cc2;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void create()
    {
        ccl = CreditCardFactory.cdtCard(5000.00);
        cc2 = CreditCardFactory.cdtCard(6000.00);
        CreditCard cc = this.classRepository.save(ccl);
        Assert.assertSame(ccl.getCredits(), cc.getCredits());
        CreditCard ccc = this.classRepository.save(cc2);
        Assert.assertSame(cc2.getCredits(), ccc.getCredits());
    }

    @Test
    public void read()
    {
        String s = "5000.00";
        CreditCard cc1 = this.classRepository.findById(s).orElse(null);

        Assert.assertEquals(s, cc1.getCredits());
        System.out.println(cc1.getCredits());
    }

    @Test
    public void update()
    {
        ccl = CreditCardFactory.cdtCard(5000.00);
        CreditCard cc = this.classRepository.save(ccl);
        Assert.assertSame(ccl.getCredits(), cc.getCredits());
        System.out.println(cc.getCredits());
    }

    @Test
    public void delete()
    {
        String s = "5000.00";
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