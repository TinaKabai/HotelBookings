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
import za.ac.cput.Domain.Payment.Receipt;
import za.ac.cput.Factory.ReceiptFactory;
import za.ac.cput.Service.Payment.implementations.ReceiptServiceImpl;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ReceiptServiceImplTest {

    @Autowired
    private ReceiptServiceImpl service;
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
        Receipt r = this.service.create(rl);
        Assert.assertEquals(rl.getPaymentRef(), r.getPaymentRef());
    }

    @Test
    public void read() {
        String s = "79559456";
        Receipt rl = this.service.read(s);

        Assert.assertEquals(s, rl.getPaymentRef());
        System.out.println(rl.getPaymentRef() + " " + rl.getItemDescription());
    }

    @Test
    public void update() {
        rl = ReceiptFactory.receipt("10 May 2019", "78557888", "78855", "79559456",
                "7410");
        Receipt r = this.service.update(rl);
        Assert.assertEquals(rl.getPaymentRef(), r.getPaymentRef());
        System.out.println(r.getPaymentRef() + "\n" + r.getItemDescription());
    }

    @Test
    public void delete() {
        String s = "79559456";
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