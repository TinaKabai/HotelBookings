package za.ac.cput.Repository.payment.implementations;

/*import org.springframework.stereotype.Repository;
import za.ac.cput.Domain.Payment.DebitCard;
import za.ac.cput.Repository.payment.DebitCardRepository;

import java.util.HashMap;
import java.util.Map;

@Repository*/
/*public class DebitCardRepositoryImpl implements DebitCardRepository {

    private static DebitCardRepositoryImpl repository = null;
    private Map<DebitCard, DebitCard> debitCards;

    private DebitCardRepositoryImpl() {
        this.debitCards = new HashMap<>();
    }

    private DebitCard hasDebitCard(String cardNo) {
        return this.debitCards.values().stream()
                .filter(debitCard -> debitCard.getCardNo().trim().equals(cardNo))
                .findAny()
                .orElse(null);
    }

    public static DebitCardRepositoryImpl getRepository() {
        if (repository == null) repository = new DebitCardRepositoryImpl();
        return repository;
    }

    public DebitCard create(DebitCard debitCard) {
        this.debitCards.put(debitCard, debitCard);
        return debitCard;
    }

    public DebitCard read(final String cardNo){
        DebitCard debitCard = hasDebitCard(cardNo);
        return debitCard;
    }

    public void delete(String cardNo) {
        DebitCard debitCard = hasDebitCard(cardNo);
        if (debitCard != null) this.debitCards.remove(debitCard);
    }

    public DebitCard update(DebitCard creditCard) {
        DebitCard toDelete = hasDebitCard(creditCard.getCardNo());
        if(toDelete != null) {
            this.debitCards.remove(toDelete);
            return create(creditCard);
        }
        return null;
    }
    public Map<DebitCard, DebitCard> getAll(){
        return this.debitCards;
    }
}*/
