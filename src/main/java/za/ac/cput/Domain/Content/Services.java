package za.ac.cput.Domain.Content;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Services {

    @Id
    private String servName;
    private String description;
    private double price;

    public Services() {
    }

    private Services(Builder builder) {
        this.servName = builder.sName;
        this.description = builder.description;
        this.price = builder.price;
    }

    public String getServName() {
        return servName;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public static class Builder {
        private String sName;
        private String description;
        private double price;


        public Builder sName(String sName) {
            this.sName = sName;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder price(double price) {
            this.price = price;
            return this;
        }

    public Services build() {
        return new Services(this);
    }

        public Builder copy(Services services) {
            this.sName = services.servName;
            this.description = services.description;
            this.price = services.price;

            return this;
        }
}
}
