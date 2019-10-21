package za.ac.cput.Service.Payment.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Payment.Card;
import za.ac.cput.Repository.payment.CardRepository;
import za.ac.cput.Service.Payment.CardService;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    private static CardService service = null;

    @Autowired
    private CardRepository repo;

    private CardServiceImpl(){

    }

    public static CardService getService()
    {
        if(service == null) service = new CardServiceImpl();
        return service;
    }

    @Override
    public Card retrieveById(String id)
    {
        List<Card> cards = getAll();
        for(Card c: cards)
        {
            if (c.getCardNo().equals(id)) return c;
        }
        return null;
    }

    @Override
    public List<Card> getAll() {
        return this.repo.findAll();
    }

    public Card create(Card card) {
        return this.repo.save(card);
    }


    public Card read(String s) {
        return this.repo.findById(s).orElse(null);
    }


    public Card update(Card card) {
        return this.repo.save(card);
    }

    @Override
    public void delete(String s) {
        this.repo.deleteById(s);
    }
}
