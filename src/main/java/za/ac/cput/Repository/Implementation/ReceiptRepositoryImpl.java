package za.ac.cput.Repository.Implementation;

import za.ac.cput.Domain.Payment.Receipt;
import za.ac.cput.Repository.ReceiptRepository;

import java.util.HashSet;
import java.util.Set;

public class ReceiptRepositoryImpl implements ReceiptRepository {

    private static ReceiptRepositoryImpl repository = null;
    private Set<Receipt> receipts;

    private ReceiptRepositoryImpl() {
        this.receipts = new HashSet<>();
    }

    private Receipt theReceipt(String itemDescription) {
        return this.receipts.stream()
                .filter(receipt -> receipt.getItemDescription().trim().equals(itemDescription))
                .findAny()
                .orElse(null);
    }

    public static ReceiptRepositoryImpl getRepository() {
        if (repository == null) repository = new ReceiptRepositoryImpl();
        return repository;
    }

    public Receipt create(Receipt receipt) {
        this.receipts.add(receipt);
        return receipt;
    }

    public Receipt read(final String itemDescription){
        Receipt receipt = theReceipt(itemDescription);
        return receipt;
    }

    public void delete(String itemDescription) {
        Receipt receipt = theReceipt(itemDescription);
        if (receipt != null) this.receipts.remove(receipt);
    }

    public Receipt update(Receipt receipt){
        Receipt toDelete = theReceipt(receipt.getItemDescription());
        if(toDelete != null) {
            this.receipts.remove(toDelete);
            return create(receipt);
        }
        return null;
    }

    public Set<Receipt> getAll(){
        return this.receipts;
    }
}
