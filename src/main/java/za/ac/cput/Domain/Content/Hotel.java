package za.ac.cput.Domain.Content;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Hotel {

    @Id
    private String city;
    private int zip;
    private String hotelName;
    private String street;
    private String telephone;
    private String website;

    public Hotel() {
    }

    private Hotel(Builder builder) {
        this.city = builder.city;
        this.zip = builder.zip;
        this.hotelName = builder.hotelName;
        this.street = builder.street;
        this.telephone = builder.telephone;
        this.website = builder.website;
    }

    public String getCity() {
        return city;
    }

    public int getZip() {
        return zip;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getStreet() {
        return street;
    }

    public String getPhone() {
        return telephone;
    }

    public String getWebsite() {
        return website;
    }

    public static class Builder {
        private String city;
        private int zip;
        private String hotelName;
        private String street;
        private String telephone;
        private String website;

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder zip(int zip) {
            this.zip = zip;
            return this;
        }

        public Builder hotelName(String hotelName) {
            this.hotelName = hotelName;
            return this;
        }

        public Builder street(String street) {
            this.street = street;
            return this;
        }

        public Builder telphone(String phone) {
            this.telephone = phone;
            return this;
        }

        public Builder website(String website) {
            this.city = website;
            return this;
        }

        public Hotel build() {
            return new Hotel(this);
        }

        public Builder copy(Hotel hotel) {
            this.city = hotel.city;
            this.zip = hotel.zip;
            this.hotelName = hotel.hotelName;
            this.street = hotel.street;
            this.telephone = hotel.telephone;
            this.website = hotel.website;

            return this;
        }

    }
}
