package za.ac.cput.Service.Payment.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Payment.Cash;
import za.ac.cput.Repository.payment.CashRepository;
import za.ac.cput.Service.Payment.CashService;

import java.util.List;

@Service
public class CashServiceImpl implements CashService {

    private static CashService service = null;

    @Autowired
    private CashRepository repo;

    private CashServiceImpl() {

    }

    public static CashService getService() {
        if (service == null) service = new CashServiceImpl();
        return service;
    }

    @Override
    public Cash retrieveById(String id) {
        List<Cash> cashList = getAll();
        for (Cash c : cashList) {
            if (c.getAmount().equals(id)) return c;
        }
        return null;
    }

    @Override
    public List<Cash> getAll() {
        return this.repo.findAll();
    }

    public Cash create(Cash cash) {
        return this.repo.save(cash);
    }


    public Cash read(String s) {
        return this.repo.findById(s).orElse(null);
    }


    public Cash update(Cash cash) {
        return this.repo.save(cash);
    }

    @Override
    public void delete(String s) {
        this.repo.deleteById(s);
    }
}