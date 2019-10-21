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
import za.ac.cput.Domain.Payment.Receipt;
import za.ac.cput.Factory.ReceiptFactory;
import za.ac.cput.Repository.payment.ReceiptRepository;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ReceiptRepositoryImplTest {

    @Autowired
    private ReceiptRepository classRepository;
    private List<Receipt> classes;
    Receipt rl;
    Receipt r2;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void create() {
        rl = ReceiptFactory.receipt("10 May 2019", "78557888", "78855", "79559456",
                                    "7410");
        r2 = ReceiptFactory.receipt("18 September 2019", "78557980", "78800", "79559789",
                                    "7780");
        Receipt r = this.classRepository.save(rl);
        Assert.assertEquals(rl.getPaymentRef(), r.getPaymentRef());
        Receipt rr = this.classRepository.save(r2);
        Assert.assertEquals(r2.getPaymentRef(), rr.getPaymentRef());
    }

    @Test
    public void read() {
        String s = "79559456";
        Receipt r1 = this.classRepository.findById(s).orElse(null);

        Assert.assertEquals(s, r1.getPaymentRef());
        System.out.println(r1.getPaymentRef() + " " + r1.getItemDescription());
    }

    @Test
    public void update()
    {
        rl = ReceiptFactory.receipt("10 May 2019", "78557888", "78855", "79559456",
                "7410");
        Receipt r = this.classRepository.save(rl);
        Assert.assertEquals(rl.getPaymentRef(), r.getPaymentRef());
        System.out.println(r.getPaymentRef() + "\n" + r.getItemDescription());
    }

    @Test
    public void delete()
    {
        String s = "79559456";
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