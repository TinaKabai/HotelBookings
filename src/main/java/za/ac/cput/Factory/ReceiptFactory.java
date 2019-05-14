package za.ac.cput.Factory;

import za.ac.cput.Domain.Payment.Receipt;

public class ReceiptFactory {
    public static Receipt receipt(String date, String branchNo, String itemDescription, String paymentRef, String transactionId){
        return new Receipt.Builder().date(date).branchNumber(branchNo).descrption(itemDescription).paymentReference(paymentRef).transaction(transactionId).build();
    }
}
