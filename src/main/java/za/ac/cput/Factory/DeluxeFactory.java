package za.ac.cput.Factory;

import za.ac.cput.Domain.Content.Deluxe;

public class DeluxeFactory {
    public static Deluxe delux(boolean deluxe){
        return new Deluxe.Builder().deluxe(deluxe).build();
    }
}
