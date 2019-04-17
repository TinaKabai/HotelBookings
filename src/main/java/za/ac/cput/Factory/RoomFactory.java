package za.ac.cput.Factory;

import za.ac.cput.Domain.Content.Room;

public class RoomFactory {

    public static Room findRoom(int roomNo, String roomType, String roomStatus, int floor, double price){
        return new Room.Builder().roomNo(roomNo).roomType(roomType).roomStatus(roomStatus).floor(floor).price(price).build();
    }
}
