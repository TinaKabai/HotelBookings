package za.ac.cput.Service.impl;

import za.ac.cput.Domain.Payment.Cash;
import za.ac.cput.Repository.CashRepository;
import za.ac.cput.Repository.Implementation.CashRepositoryImpl;
import za.ac.cput.Service.CashService;

import java.util.Map;

public class CashServiceImpl implements CashService {

    private CashServiceImpl service = null;
    private CashRepository repository;

    private CashServiceImpl(){
        this.repository = CashRepositoryImpl.getRepository();
    }

    public CashService getService(){
        if (service == null) service = new CashServiceImpl();
        return null;
    }

    @Override
    public Cash create(Cash cash) {
        return this.repository.create(cash);
    }

    @Override
    public Cash update(Cash cash) {
        return this.repository.update(cash);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Cash read(String s) {
        return this.repository.read(s);
    }

    public Map<Cash, Cash> getAll() {
        return this.repository.getAll();
    }
}
