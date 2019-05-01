package za.ac.cput.Factory;

import za.ac.cput.Domain.Content.Booking;

public class BookingFactory {

    public static Booking bookings(boolean pay){
        return new Booking.Builder().pay(pay).build();
    }
}
