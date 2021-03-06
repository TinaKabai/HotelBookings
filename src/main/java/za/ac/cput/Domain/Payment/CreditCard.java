package za.ac.cput.Domain.Payment;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CreditCard extends Card {

    @Id
    private double credits;

    public CreditCard() {
    }

    private CreditCard(Builder builder) {
        this.credits = builder.credits;
    }

    public double getCredits() {
        return 0;
    }
    public String toString(){
        return "";
    }

    public static class Builder {
        private double credits;

        public Builder credit(double credits) {
            this.credits = credits;
            return this;
        }
        public CreditCard build() {
            return new CreditCard(this);
        }

        public Builder copy(CreditCard creditCard) {
            this.credits = creditCard.credits;

            return this;
        }
    }
}

