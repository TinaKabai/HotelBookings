package za.ac.cput.Repository.Implementation;

import za.ac.cput.Domain.Payment.Card;
import za.ac.cput.Repository.CardRepository;

import java.util.HashSet;
import java.util.Set;

public class CardRepositoryImpl implements CardRepository {

    private static CardRepositoryImpl repository = null;
    private Set<Card> cards;

    private CardRepositoryImpl() {
        this.cards = new HashSet<Card>();
    }

    public static CardRepositoryImpl getRepository() {
        if (repository == null) repository = new CardRepositoryImpl();
        return repository;
    }
    public Card create(Card card) {
        this.cards.add(card);
        return card;
    }

    public Card read(String cardNo) {
        // find the course that matches the id and return it if exist
        return null;
    }

    public void delete(String cardNo) {
        // find the course, delete it if it exist
    }

    public Card update(Card card) {
        // find the course, update it and delete it if it exists
        return card;
    }
    public Set<Card> getAll(){
        return this.cards;
    }
}
