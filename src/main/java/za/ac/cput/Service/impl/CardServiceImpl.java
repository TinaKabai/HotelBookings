package za.ac.cput.Service.impl;

import za.ac.cput.Domain.Payment.Card;
import za.ac.cput.Repository.CardRepository;
import za.ac.cput.Repository.Implementation.CardRepositoryImpl;
import za.ac.cput.Service.CardService;

import java.util.Map;

public class CardServiceImpl implements CardService {

    private CardServiceImpl service = null;
    private CardRepository repository;

    private CardServiceImpl(){
        this.repository = CardRepositoryImpl.getRepository();
    }

    public CardService getService(){
        if (service == null) service = new CardServiceImpl();
        return null;
    }

    @Override
    public Card create(Card card) {
        return this.repository.create(card);
    }

    @Override
    public Card update(Card card) {
        return this.repository.update(card);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Card read(String s) {
        return this.repository.read(s);
    }

    public Map<Card, Card> getAll() {
        return this.repository.getAll();
    }
}
