package za.ac.cput.Factory;

import za.ac.cput.Domain.Content.Deluxe;
import za.ac.cput.Domain.Content.Room;

public class DeluxeFactory {
    public static Room delux(int roomNo, String roomType, String roomStatus, int floor, double price){
        return new Deluxe.Builder().roomNo(roomNo).roomType(roomType).roomStatus(roomStatus).floor(floor).price(price).build();
    }
}
