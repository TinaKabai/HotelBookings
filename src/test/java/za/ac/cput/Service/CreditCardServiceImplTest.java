package za.ac.cput.Service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import za.ac.cput.Domain.Payment.CreditCard;
import za.ac.cput.Factory.CreditCardFactory;
import za.ac.cput.Repository.CreditCardRepository;
import za.ac.cput.Repository.Implementation.CreditCardRepositoryImpl;

import java.util.Map;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class CreditCardServiceImplTest {

    private CreditCardRepository repository;

    private CreditCard creditCard;

    @Before
    public void setUp() throws Exception {

        this.repository = (CreditCardRepositoryImpl) CreditCardRepositoryImpl.getRepository();

        this.creditCard = CreditCardFactory.cdtCard(7.9);
    }

    @Test
    public void d_getAll() {
        Map<CreditCard, CreditCard> creditCard = this.repository.getAll();

        System.out.println("In getAll, all = " + creditCard);
    }

    @Test
    public void create() {

        CreditCard created = this.repository.create(this.creditCard);

        System.out.println("In create, created = " + created);

        Assert.assertNotNull(created);

        Assert.assertSame(created, this.creditCard);
    }

    @Test
    public void read() {

        CreditCard read = this.repository.read(creditCard.getCardNo());

        System.out.println("In read, read = " + read);

        d_getAll();
        Assert.assertEquals(read, creditCard);
    }

    @Test
    public void update() {

        double newCredCard = 5.0;

        CreditCard updated = new CreditCard.Builder().credit(newCredCard).build();

        System.out.println("In update, about_to_updated = " + updated);

        this.repository.update(updated);

        Assert.assertSame(newCredCard, updated.getCredits());
        d_getAll();
    }

    @Test
    public void delete() {

        this.repository.delete(creditCard.getCardNo());
        d_getAll();
    }
}