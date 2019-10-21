package za.ac.cput.Domain.Payment;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Receipt extends Card {

    @Id
    private String date;
    private String branchNo;
    private String itemDescription;
    private String paymentRef;
    private String transactionId;

    public Receipt() {
    }

    private Receipt(Builder builder){
        this.date = builder.date;
        this.branchNo = builder.branchNo;
        this.itemDescription = builder.itemDescription;
        this.paymentRef = builder.paymentRef;
        this.transactionId = builder.transactionId;
    }

    public String getDate() {
        return date;
    }

    public String getBranchNo() {
        return branchNo;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public String getPaymentRef() {
        return paymentRef;
    }

    public String getTranactionId() {
        return transactionId;
    }
    public static class Builder{
        private String date;
        private String branchNo;
        private String itemDescription;
        private String paymentRef;
        private String transactionId;

        public Builder date(String date){
            this.date = date;
            return this;
        }
        public Builder branchNumber(String branchNo){
            this.branchNo = branchNo;
            return this;
        }
        public Builder descrption(String itemDescription){
            this.itemDescription = itemDescription;
            return this;
        }
        public Builder paymentReference(String paymentRef){
            this.paymentRef = paymentRef;
            return this;
        }
        public Builder transaction(String transactionId){
            this.transactionId = transactionId;
            return this;
        }
        public Receipt build() {
            return new Receipt(this);
        }

        public Builder copy(Receipt receipt) {
            this.date = receipt.date;
            this.branchNo = receipt.branchNo;
            this.itemDescription = receipt.itemDescription;
            this.paymentRef = receipt.paymentRef;
            this.transactionId = receipt.transactionId;

            return this;
        }
    }
}
