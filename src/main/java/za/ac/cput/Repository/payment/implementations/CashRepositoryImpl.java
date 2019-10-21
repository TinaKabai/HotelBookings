package za.ac.cput.Repository.payment.implementations;

/*import org.springframework.stereotype.Repository;
import za.ac.cput.Domain.Payment.Cash;
import za.ac.cput.Repository.payment.CashRepository;

import java.util.HashMap;
import java.util.Map;

@Repository*/
/*public class CashRepositoryImpl implements CashRepository {

    private static CashRepositoryImpl repository = null;
    private Map<Cash, Cash> cashs;

    private CashRepositoryImpl() {
        this.cashs = new HashMap<>();
    }

    private Cash hasCash(String amount) {
        return this.cashs.values().stream()
                .filter(cash -> cash.getAmount().trim().equals(amount))
                .findAny()
                .orElse(null);
    }

    public static CashRepositoryImpl getRepository() {
        if (repository == null) repository = new CashRepositoryImpl();
        return repository;
    }
    public Cash create(Cash cash) {
        this.cashs.put(cash, cash);
        return cash;
    }

    public Cash read(String amount){
        Cash cash = hasCash(amount);
        return cash;
    }

    public void delete(String amount) {
        Cash cash = hasCash(amount);
        if (cash != null) this.cashs.remove(cash);
    }

    public Cash update(Cash cash) {
        Cash toDelete = hasCash(cash.getAmount());
        if(toDelete != null) {
            this.cashs.remove(toDelete);
            return create(cash);
        }
        return null;
    }

    public Map<Cash, Cash> getAll(){
        return this.cashs;
    }
}*/
