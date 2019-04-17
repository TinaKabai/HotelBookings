package za.ac.cput.Domain.Payment;

public class Cash implements Transaction {

    private double amount;
    private double change;

    public Cash() {
    }

    private Cash(Builder builder) {
        this.amount = builder.amount;
        this.change = builder.change;
    }

    public double getAmount() {
        return amount;
    }
    public double getChange() {
        return change;
    }
    // method implemented from Transaction interface
    public double pay() {
        return 0;
    }

public static class Builder{
    private double amount;
    private double change;

    public Builder amount(double amount){
        this.amount = amount;
        return this;
    }
    public Builder change(double change){
        this.change = change;
        return this;
    }
    public Cash build() {
        return new Cash(this);
    }
}
}
