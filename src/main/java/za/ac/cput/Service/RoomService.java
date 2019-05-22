package za.ac.cput.Service;

import za.ac.cput.Domain.Content.Room;

import java.util.Set;

public interface RoomService extends IService<Room, String> {

    Set<Room> getAll();
}
