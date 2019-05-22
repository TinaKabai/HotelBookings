package za.ac.cput.Repository.Implementation;

import za.ac.cput.Domain.Payment.CreditCard;
import za.ac.cput.Repository.CreditCardRepository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CreditCardRepositoryImpl implements CreditCardRepository {

    private static CreditCardRepositoryImpl repository = null;
    private Map<CreditCard, CreditCard> creditCards;

    private CreditCardRepositoryImpl() {
        this.creditCards = new HashMap<>();
    }

    private CreditCard hasCreditCard(String cardNo) {
        return this.creditCards.values().stream()
                .filter(creditCard -> creditCard.getCardNo().trim().equals(cardNo))
                .findAny()
                .orElse(null);
    }

    public static CreditCardRepositoryImpl getRepository() {
        if (repository == null) repository = new CreditCardRepositoryImpl();
        return repository;
    }

    public CreditCard create(CreditCard creditCard) {
        this.creditCards.put(creditCard, creditCard);
        return creditCard;
    }

    public CreditCard read(final String cardNo){
        CreditCard card = hasCreditCard(cardNo);
        return card;
    }

    public void delete(String cardNo) {
        CreditCard creditCard = hasCreditCard(cardNo);
        if (creditCard != null) this.creditCards.remove(creditCard);
    }

    public CreditCard update(CreditCard creditCard) {
        CreditCard toDelete = hasCreditCard(creditCard.getCardNo());
        if(toDelete != null) {
            this.creditCards.remove(toDelete);
            return create(creditCard);
        }
        return null;
    }
    public Map<CreditCard, CreditCard> getAll(){
        return this.creditCards;
    }
}
