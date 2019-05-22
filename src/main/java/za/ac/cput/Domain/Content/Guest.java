package za.ac.cput.Domain.Content;

import za.ac.cput.Domain.Payment.Transaction;

public class Guest extends Demographic implements Transaction {
    private String name;
    private String number;
    private String homeAddress;

    public Guest() {
    }

    private Guest(Builder builder) {
        this.name = builder.name;
        this.number = builder.number;
        this.homeAddress = builder.homeAddress;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public double pay() {
        return 0;
    }

    public static class Builder{
        private String name;
        private String number;
        private String homeAddress;

        public Builder name(String name){
            this.name = name;
            return this;
        }
        public Builder number(String number){
            this.number = number;
            return this;
        }
        public Builder address(String homeAddress){
            this.homeAddress = homeAddress;
            return this;
        }
        public Guest build() {
            return new Guest(this);
        }

        public Builder copy(Guest guest) {
            this.name = guest.name;
            this.number = guest.number;
            this.homeAddress = guest.homeAddress;

            return this;
        }
    }
}
