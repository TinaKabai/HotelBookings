package za.ac.cput.Service.impl;

import za.ac.cput.Domain.Payment.CreditCard;
import za.ac.cput.Repository.CardRepository;
import za.ac.cput.Repository.CreditCardRepository;
import za.ac.cput.Repository.Implementation.CreditCardRepositoryImpl;
import za.ac.cput.Service.CreditCardService;

import java.util.Map;

public class CreditCardServiceImpl implements CreditCardService {

    private CreditCardServiceImpl service = null;
    private CreditCardRepository repository;

    private CreditCardServiceImpl(){
        this.repository = CreditCardRepositoryImpl.getRepository();
    }

    public CreditCardService getService(){
        if (service == null) service = new CreditCardServiceImpl();
        return null;
    }

    @Override
    public CreditCard create(CreditCard creditCard) {
        return this.repository.create(creditCard);
    }

    @Override
    public CreditCard update(CreditCard creditCard) {
        return this.repository.update(creditCard);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public CreditCard read(String s) {
        return this.repository.read(s);
    }

    public Map<CreditCard, CreditCard> getAll() {
        return this.repository.getAll();
    }
}
