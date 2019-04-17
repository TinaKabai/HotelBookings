package za.ac.cput.Domain.Payment;

public class DebitCard extends Card {

    private double deductions;

    public DebitCard() {
    }
    private DebitCard(Builder builder){
        this.deductions = builder.deductions;
    }

    public double getDeductions() {
        return deductions;
    }

 public static class Builder{
     private double deductions;

     public Builder deduction(double deductions){
         this.deductions = deductions;
         return this;
     }
     public DebitCard build() {
         return new DebitCard(this);
     }
 }
}
