package za.ac.cput.Domain.Content;

import za.ac.cput.Domain.Payment.Transaction;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Booking extends  Guest implements Transaction {

    @Id
    private boolean pay;

    public Booking() {
        super();
    }

    private Booking(Builder builder) {
        this.pay = builder.pay;
    }

        public boolean isPay() {
            return pay;
        }

    public static class Builder {
        private boolean pay;

        public Builder pay(boolean pay) {
            this.pay = pay;
            return this;
        }
        public Booking build() {
            return new Booking(this);
        }

        public Builder copy(Booking booking) {
            this.pay = booking.pay;

            return this;
        }
    }
}
