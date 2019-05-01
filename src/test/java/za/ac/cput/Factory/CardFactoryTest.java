package za.ac.cput.Factory;


import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.Domain.Payment.Card;
import za.ac.cput.Factory.CardFactory;

public class CardFactoryTest {

    @Test

    public void cards(){

        Card card = CardFactory.guestCard("6008158300567190 ", 2002);

        Assert.assertEquals("6008158300567190 2002", card.getCardNo(), card.getPin());
    }

}