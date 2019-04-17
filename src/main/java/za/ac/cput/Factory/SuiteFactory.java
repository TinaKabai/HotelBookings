package za.ac.cput.Factory;

import za.ac.cput.Domain.Content.Suite;
import za.ac.cput.Domain.Content.Room;

public class SuiteFactory {
    public static Room suit(int roomNo, String roomType, String roomStatus, int floor, double price){
        return new Suite.Builder().roomNo(roomNo).roomType(roomType).roomStatus(roomStatus).floor(floor).price(price).build();
    }
}
