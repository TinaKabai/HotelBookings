package za.ac.cput.Factory;

import za.ac.cput.Domain.Activites.Event;

public class EventFactory {
    public static Event events(String eventName, String hotelName, String date, double cost){
        return new Event.Builder().event(eventName).hotel(hotelName).date(date).build();
    }
}
