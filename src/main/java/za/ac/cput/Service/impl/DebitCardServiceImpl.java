package za.ac.cput.Service.impl;

import za.ac.cput.Domain.Payment.DebitCard;
import za.ac.cput.Repository.DebitCardRepository;
import za.ac.cput.Repository.Implementation.DebitCardRepositoryImpl;
import za.ac.cput.Service.DebitCardService;

import java.util.Map;

public class DebitCardServiceImpl implements DebitCardService {

    private DebitCardServiceImpl service = null;
    private DebitCardRepository repository;

    private DebitCardServiceImpl(){
        this.repository = DebitCardRepositoryImpl.getRepository();
    }

    public DebitCardService getService(){
        if (service == null) service = new DebitCardServiceImpl();
        return null;
    }

    @Override
    public DebitCard create(DebitCard debitCard) {
        return this.repository.create(debitCard);
    }

    @Override
    public DebitCard update(DebitCard debitCard) {
        return this.repository.update(debitCard);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public DebitCard read(String s) {
        return this.repository.read(s);
    }

    public Map<DebitCard, DebitCard> getAll() {
        return this.repository.getAll();
    }
}
