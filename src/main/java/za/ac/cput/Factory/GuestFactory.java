package za.ac.cput.Factory;

import za.ac.cput.Domain.Content.Guest;

public class GuestFactory {
    public static Guest findGuest(String name, String number, String address){
        return new Guest.Builder().name(name).number(number).address(address).build();
    }
}
