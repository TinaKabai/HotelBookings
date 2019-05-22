package za.ac.cput.Service.impl;

import za.ac.cput.Domain.Payment.Receipt;
import za.ac.cput.Repository.Implementation.ReceiptRepositoryImpl;
import za.ac.cput.Repository.ReceiptRepository;
import za.ac.cput.Service.ReceiptService;

import java.util.Set;

public class ReceiptServiceImpl implements ReceiptService {

    private ReceiptServiceImpl service = null;
    private ReceiptRepository repository;

    private ReceiptServiceImpl(){
        this.repository = ReceiptRepositoryImpl.getRepository();
    }

    public ReceiptService getService(){
        if (service == null) service = new ReceiptServiceImpl();
        return null;
    }

    @Override
    public Receipt create(Receipt receipt) {
        return this.repository.create(receipt);
    }

    @Override
    public Receipt update(Receipt receipt) {
        return this.repository.update(receipt);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Receipt read(String s) {
        return this.repository.read(s);
    }

    public Set<Receipt> getAll() {
        return this.repository.getAll();
    }
}
