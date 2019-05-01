package za.ac.cput.Repository.Implementation;

import za.ac.cput.Domain.Payment.DebitCard;
import za.ac.cput.Repository.DebitCardRepository;

import java.util.HashSet;
import java.util.Set;

public class DebitCardRepositoryImpl implements DebitCardRepository {

    private static DebitCardRepositoryImpl repository = null;
    private Set<DebitCard> debitCards;

    private DebitCardRepositoryImpl() {
        this.debitCards = new HashSet<DebitCard>();
    }

    public static DebitCardRepositoryImpl getRepository() {
        if (repository == null) repository = new DebitCardRepositoryImpl();
        return repository;
    }


    public DebitCard create(DebitCard debitCard) {
        this.debitCards.add(debitCard);
        return debitCard;
    }

    public DebitCard read(String cardNo) {
        // find the course that matches the id and return it if exist
        return null;
    }

    public void delete(String cardNo) {
        // find the course, delete it if it exist
    }

    public DebitCard update(DebitCard debitCard) {
        // find the course, update it and delete it if it exists
        return debitCard;
    }
    public Set<DebitCard> getAll(){
        return this.debitCards;
    }
}
