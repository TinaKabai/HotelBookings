package za.ac.cput.Repository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import za.ac.cput.Domain.Payment.Cash;
import za.ac.cput.Factory.CashFactory;
import za.ac.cput.Repository.Implementation.CashRepositoryImpl;

import java.util.Map;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class CashRepositoryImplTest {

    private CashRepository repository;

    private Cash cash;

    @Before
    public void setUp() throws Exception {

        this.repository = (CashRepositoryImpl) CashRepositoryImpl.getRepository();

        this.cash = CashFactory.cash("1000.00", 55.00);
    }

    @Test
    public void d_getAll() {
        Map<Cash, Cash> admin = this.repository.getAll();

        System.out.println("In getAll, all = " + admin);
    }

    @Test
    public void create() {

        Cash created = this.repository.create(this.cash);

        System.out.println("In create, created = " + created);

        Assert.assertNotNull(created);

        Assert.assertSame(created, this.cash);
    }

    @Test
    public void read() {

        Cash read = this.repository.read(cash.getAmount());

        System.out.println("In read, read = " + read);

        d_getAll();
        Assert.assertEquals(read, cash);
    }

    @Test
    public void update() {

        String newCash = "15000.99";

        Cash updated = new Cash.Builder().amount(newCash).build();

        System.out.println("In update, about_to_updated = " + updated);

        this.repository.update(updated);

        Assert.assertEquals(newCash, updated.getAmount());
        d_getAll();
    }

    @Test
    public void delete() {

        this.repository.delete(cash.getAmount());
        d_getAll();
    }
}