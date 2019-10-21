package za.ac.cput.Service.Content;

import za.ac.cput.Domain.Content.Room;
import za.ac.cput.Service.GenIService;

import java.util.List;
import java.util.Set;

public interface RoomService extends GenIService<Room, String> {

    Room retrieveById(String id);
    List<Room> getAll();
}
