package za.ac.cput.Repository.Implementation;

import za.ac.cput.Domain.Payment.Receipt;
import za.ac.cput.Repository.ReceiptRepository;

import java.util.HashSet;
import java.util.Set;

public class ReceiptRepositoryImpl implements ReceiptRepository {

    private static ReceiptRepositoryImpl repository = null;
    private Set<Receipt> receipts;

    private ReceiptRepositoryImpl() {
        this.receipts = new HashSet<Receipt>();
    }

    public static ReceiptRepositoryImpl getRepository() {
        if (repository == null) repository = new ReceiptRepositoryImpl();
        return repository;
    }

    public Receipt create(Receipt receipt) {
        this.receipts.add(receipt);
        return receipt;
    }

    public Receipt read(String password) {
        // find the course that matches the id and return it if exist
        return null;
    }

    public void delete(String paymentRef) {
        // find the course, delete it if it exist
    }

    public Receipt update(Receipt receipt) {
        // find the course, update it and delete it if it exists
        return receipt;
    }

    public Set<Receipt> getAll(){
        return this.receipts;
    }
}
