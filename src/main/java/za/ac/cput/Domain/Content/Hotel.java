package za.ac.cput.Domain.Content;

public class Hotel {
    private String city;
    private int zip;
    private String hotelName;
    private String street;
    private int telephone;
    private String website;

    public Hotel() {
    }

    private Hotel(Builder builder){
        this.city = builder.city;
        this.zip = builder.zip;
        this.hotelName = builder.street;
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

    public int getPhone() {
        return telephone;
    }

    public String getWebsite() {
        return website;
    }
public static class Builder{
    private String city;
    private int zip;
    private String hotelName;
    private String street;
    private int telephone;
    private String website;

    public Builder city(String city){
        this.city = city;
        return this;
    }
    public Builder zip(int zip){
        this.zip = zip;
        return this;
    }
    public Builder hotelName(String hotelName){
        this.hotelName = hotelName;
        return this;
    }
    public Builder street(String street){
        this.street = street;
        return this;
    }
    public Builder telphone(int phone){
        this.telephone = phone;
        return this;
    }
    public Builder website(String city){
        this.city = city;
        return this;
    }
    public Hotel build(){
        return new Hotel(this);
    }
  }
}
