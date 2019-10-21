package za.ac.cput.Service.Payment.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Payment.DebitCard;
import za.ac.cput.Repository.payment.DebitCardRepository;
import za.ac.cput.Service.Payment.DebitCardService;

import java.util.List;

@Service
public class DebitCardServiceImpl implements DebitCardService {

    private static DebitCardService service = null;

    @Autowired
    private DebitCardRepository repo;

    private DebitCardServiceImpl() {

    }

    public static DebitCardService getService() {
        if (service == null) service = new DebitCardServiceImpl();
        return service;
    }

    @Override
    public DebitCard retrieveById(String id) {
        List<DebitCard> debitCards = getAll();
        for (DebitCard dc : debitCards) {
            if (dc.getCardNo().equals(id)) return dc;
        }
        return null;
    }

    @Override
    public List<DebitCard> getAll() {
        return this.repo.findAll();
    }

    public DebitCard create(DebitCard debitCard) {
        return this.repo.save(debitCard);
    }


    public DebitCard read(String s) {
        return this.repo.findById(s).orElse(null);
    }


    public DebitCard update(DebitCard debitCard) {
        return this.repo.save(debitCard);
    }

    @Override
    public void delete(String s) {
        this.repo.deleteById(s);
    }
}
