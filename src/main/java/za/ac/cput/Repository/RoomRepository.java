package za.ac.cput.Repository;

import za.ac.cput.Domain.Content.Room;

import java.util.Set;

public interface RoomRepository extends IRepository<Room, String> {

    Set<Room> getAll();
}
