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
import za.ac.cput.Domain.Payment.DebitCard;
import za.ac.cput.Factory.DebitCardFactory;
import za.ac.cput.Repository.payment.DebitCardRepository;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class DebitCardRepositoryImplTest {

    @Autowired
    private DebitCardRepository classRepository;
    private List<DebitCard> classes;
    DebitCard dcl;
    DebitCard dc2;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void create()
    {
        dcl = DebitCardFactory.dbtCard(2000.00);
        dc2 = DebitCardFactory.dbtCard(3000.00);
        DebitCard dc = this.classRepository.save(dcl);
        Assert.assertSame(dcl.getDeductions(), dc.getDeductions());
        DebitCard dcd = this.classRepository.save(dc2);
        Assert.assertSame(dc2.getDeductions(), dcd.getDeductions());
    }

    @Test
    public void read()
    {
        String s = "2000.00";
        DebitCard dc1 = this.classRepository.findById(s).orElse(null);

        Assert.assertEquals(s, dc1.getDeductions());
        System.out.println(dc1.getDeductions());
    }

    @Test
    public void update()
    {
        dcl = DebitCardFactory.dbtCard(2000.00);
        DebitCard dc = this.classRepository.save(dcl);
        Assert.assertSame(dcl.getDeductions(), dc.getDeductions());
        System.out.println(dc.getDeductions());
    }

    @Test
    public void delete()
    {
        String s = "2000.00";
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