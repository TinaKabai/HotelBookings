package za.ac.cput.Factory;

import za.ac.cput.Domain.Content.Hotel;

public class HotelFactory {

    public static Hotel chooseHotel(String city, int zip, String hName, String street, int tel, String website){
        return new Hotel.Builder().city(city).zip(zip).hotelName(hName).street(street).telphone(tel).website(website).build();
    }
}
