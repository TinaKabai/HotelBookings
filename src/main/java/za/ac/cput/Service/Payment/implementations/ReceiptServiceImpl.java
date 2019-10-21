package za.ac.cput.Service.Payment.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Payment.Receipt;
import za.ac.cput.Repository.payment.ReceiptRepository;
import za.ac.cput.Service.Payment.ReceiptService;

import java.util.List;

@Service
public class ReceiptServiceImpl implements ReceiptService {

    private static ReceiptService service = null;

    @Autowired
    private ReceiptRepository repo;

    private ReceiptServiceImpl() {

    }

    public static ReceiptService getService() {
        if (service == null) service = new ReceiptServiceImpl();
        return service;
    }

    @Override
    public Receipt retrieveById(String id) {
        List<Receipt> receipts = getAll();
        for (Receipt r : receipts) {
            if (r.getPaymentRef().equals(id)) return r;
        }
        return null;
    }

    @Override
    public List<Receipt> getAll() {
        return this.repo.findAll();
    }

    public Receipt create(Receipt receipt) {
        return this.repo.save(receipt);
    }


    public Receipt read(String s) {
        return this.repo.findById(s).orElse(null);
    }


    public Receipt update(Receipt receipt) {
        return this.repo.save(receipt);
    }

    @Override
    public void delete(String s) {
        this.repo.deleteById(s);
    }
}
