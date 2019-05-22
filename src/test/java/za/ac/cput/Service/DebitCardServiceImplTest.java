package za.ac.cput.Service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import za.ac.cput.Domain.Payment.DebitCard;
import za.ac.cput.Factory.DebitCardFactory;
import za.ac.cput.Repository.DebitCardRepository;
import za.ac.cput.Repository.Implementation.DebitCardRepositoryImpl;

import java.util.Map;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class DebitCardServiceImplTest {

    private DebitCardRepository repository;

    private DebitCard debitCard;

    @Before
    public void setUp() throws Exception {

        this.repository = (DebitCardRepositoryImpl) DebitCardRepositoryImpl.getRepository();

        this.debitCard = DebitCardFactory.dbtCard(10.5);
    }

    @Test
    public void d_getAll() {
        Map<DebitCard, DebitCard> debitCard = this.repository.getAll();

        System.out.println("In getAll, all = " + debitCard);
    }

    @Test
    public void create() {

        DebitCard created = this.repository.create(this.debitCard);

        System.out.println("In create, created = " + created);

        Assert.assertNotNull(created);

        Assert.assertSame(created, this.debitCard);
    }

    @Test
    public void read() {

        DebitCard read = this.repository.read(debitCard.getCardNo());

        System.out.println("In read, read = " + read);

        d_getAll();
        Assert.assertEquals(read, debitCard);
    }

    @Test
    public void update() {

        double newDebCard = 7.9;

        DebitCard updated = new DebitCard.Builder().deduction(newDebCard).build();

        System.out.println("In update, about_to_updated = " + updated);

        this.repository.update(updated);

        Assert.assertSame(newDebCard, updated.getDeductions());
        d_getAll();
    }

    @Test
    public void delete() {

        this.repository.delete(debitCard.getCardNo());
        d_getAll();
    }
}