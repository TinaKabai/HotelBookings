package za.ac.cput.Factory;

import za.ac.cput.Domain.Content.NonAC;
import za.ac.cput.Domain.Content.Room;

public class NonACFactory {
    public static Room accessibility(int roomNo, String roomType, String roomStatus, int floor, double price){
        return new NonAC.Builder().roomNo(roomNo).roomType(roomType).roomStatus(roomStatus).floor(floor).price(price).build();
    }
}
