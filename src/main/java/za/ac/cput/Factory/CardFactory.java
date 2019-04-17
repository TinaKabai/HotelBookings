package za.ac.cput.Factory;

import za.ac.cput.Domain.Payment.Card;

public class CardFactory {
        public static Card guestCard(int cardNo, int pin){
            return new Card.Builder().cardNumber(cardNo).pin(pin).build();
        }
}
