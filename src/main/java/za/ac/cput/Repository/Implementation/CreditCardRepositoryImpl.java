package za.ac.cput.Repository.Implementation;

import za.ac.cput.Domain.Payment.CreditCard;
import za.ac.cput.Repository.CreditCardRepository;

import java.util.HashSet;
import java.util.Set;

public class CreditCardRepositoryImpl implements CreditCardRepository {

    private static CreditCardRepositoryImpl repository = null;
    private Set<CreditCard> creditCards;

    private CreditCardRepositoryImpl() {
        this.creditCards = new HashSet<CreditCard>();
    }

    public static CreditCardRepositoryImpl getRepository() {
        if (repository == null) repository = new CreditCardRepositoryImpl();
        return repository;
    }


    public CreditCard create(CreditCard creditCard) {
        this.creditCards.add(creditCard);
        return creditCard;
    }

    public CreditCard read(String cardNo) {
        // find the course that matches the id and return it if exist
        return null;
    }

    public void delete(String cardNo) {
        // find the course, delete it if it exist
    }

    public CreditCard update(CreditCard creditCard) {
        // find the course, update it and delete it if it exists
        return creditCard;
    }
    public Set<CreditCard> getAll(){
        return this.creditCards;
    }
}
