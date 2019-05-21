package za.ac.cput.Repository.Implementation;

import za.ac.cput.Domain.Payment.Card;
import za.ac.cput.Repository.CardRepository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CardRepositoryImpl implements CardRepository {

    private static CardRepositoryImpl repository = null;
    private Map<Card, Card> cards;

    private CardRepositoryImpl() {
        this.cards = new HashMap<>();
    }

    private Card hasCard(String cardNo) {
        return this.cards.values().stream()
                .filter(card -> card.getCardNo().trim().equals(cardNo))
                .findAny()
                .orElse(null);
    }

        public static CardRepositoryImpl getRepository() {
            if (repository == null) repository = new CardRepositoryImpl();
            return repository;
        }

    public Card create(Card card) {
        this.cards.put(card, card);
        return card;
    }

    public Card read(final String cardNo){
        Card card = hasCard(cardNo);
        return card;
    }

    public void delete(String cardNo) {
        Card card = hasCard(cardNo);
        if (card != null) this.cards.remove(card);
    }

    public Card update(Card card) {
        Card toDelete = hasCard(card.getCardNo());
        if(toDelete != null) {
            this.cards.remove(toDelete);
            return create(card);
        }
        return null;
    }

    public Map<Card, Card> getAll(){
        return this.cards;
    }
}
