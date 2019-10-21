package za.ac.cput.Service.Payment.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Payment.CreditCard;
import za.ac.cput.Repository.payment.CreditCardRepository;
import za.ac.cput.Service.Payment.CreditCardService;

import java.util.List;

@Service
public class CreditCardServiceImpl implements CreditCardService {

    private static CreditCardService service = null;

    @Autowired
    private CreditCardRepository repo;

    private CreditCardServiceImpl() {

    }

    public static CreditCardService getService() {
        if (service == null) service = new CreditCardServiceImpl();
        return service;
    }

    @Override
    public CreditCard retrieveById(String id) {
        List<CreditCard> creditCards = getAll();
        for (CreditCard cc : creditCards) {
            if (cc.getCardNo().equals(id)) return cc;
        }
        return null;
    }

    @Override
    public List<CreditCard> getAll() {
        return this.repo.findAll();
    }

    public CreditCard create(CreditCard creditCard) {
        return this.repo.save(creditCard);
    }


    public CreditCard read(String s) {
        return this.repo.findById(s).orElse(null);
    }


    public CreditCard update(CreditCard creditCard) {
        return this.repo.save(creditCard);
    }

    @Override
    public void delete(String s) {
        this.repo.deleteById(s);
    }
}
