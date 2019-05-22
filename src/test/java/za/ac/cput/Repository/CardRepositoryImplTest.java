package za.ac.cput.Repository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import za.ac.cput.Domain.Payment.Card;
import za.ac.cput.Factory.CardFactory;
import za.ac.cput.Repository.Implementation.CardRepositoryImpl;

import java.util.Map;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class CardRepositoryImplTest {

    private CardRepository repository;

    private Card card;

    @Before
    public void setUp() throws Exception {

        this.repository = (CardRepositoryImpl) CardRepositoryImpl.getRepository();

        this.card = CardFactory.guestCard("6008158300567190 ", 2002);
    }

    @Test
    public void d_getAll() {
        Map<Card, Card> admin = this.repository.getAll();

        System.out.println("In getAll, all = " + admin);
    }

    @Test
    public void create() {

        Card created = this.repository.create(this.card);

        System.out.println("In create, created = " + created);

        Assert.assertNotNull(created);

        Assert.assertSame(created, this.card);
    }

    @Test
    public void read() {

        Card read = this.repository.read(card.getCardNo());

        System.out.println("In read, read = " + read);

        d_getAll();
        Assert.assertEquals(read, card);
    }

    @Test
    public void update() {

        String newCard = "6008158300123456";

        Card updated = new Card.Builder().cardNumber(newCard).build();

        System.out.println("In update, about_to_updated = " + updated);

        this.repository.update(updated);

        Assert.assertEquals(newCard, updated.getCardNo());
        d_getAll();
    }

    @Test
    public void delete() {

        this.repository.delete(card.getCardNo());
        d_getAll();
    }

}