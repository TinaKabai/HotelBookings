package za.ac.cput.Repository;


import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import za.ac.cput.Domain.Payment.Receipt;
import za.ac.cput.Factory.ReceiptFactory;
import za.ac.cput.Repository.Implementation.ReceiptRepositoryImpl;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ReceiptRepositoryImplTest {

    private ReceiptRepository repository;

    private Receipt receipt;

    @Before
    public void setUp() throws Exception {

        this.repository = (ReceiptRepositoryImpl) ReceiptRepositoryImpl.getRepository();

        this.receipt = ReceiptFactory.receipt("10 May 2019", "78557888",
                "78855", "79559456", "7410");
    }

    @Test
    public void d_getAll() {
        Set<Receipt> receipt = this.repository.getAll();

        System.out.println("In getAll, all = " + receipt);
    }

    @Test
    public void create() {

        Receipt created = this.repository.create(this.receipt);

        System.out.println("In create, created = " + created);

        Assert.assertNotNull(created);

        Assert.assertSame(created, this.receipt);
    }

    @Test
    public void read() {

        Receipt read = this.repository.read(receipt.getItemDescription());

        System.out.println("In read, read = " + read);

        d_getAll();
        Assert.assertEquals(read, receipt);
    }

    @Test
    public void update() {

        String newReceipt = "77565";

        Receipt updated = new Receipt.Builder().descrption(newReceipt).build();

        System.out.println("In update, about_to_updated = " + updated);

        this.repository.update(updated);

        Assert.assertEquals(newReceipt, updated.getItemDescription());
        d_getAll();
    }

    @Test
    public void delete() {

        this.repository.delete(receipt.getItemDescription());
        d_getAll();
    }
}