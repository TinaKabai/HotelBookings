package za.ac.cput.Repository.Implementation;

import za.ac.cput.Domain.Content.Room;
import za.ac.cput.Repository.RoomRepository;

import java.util.HashSet;
import java.util.Set;

public class RoomRepositoryImpl implements RoomRepository {

    private static RoomRepositoryImpl repository = null;
    private Set<Room> rooms;

    private RoomRepositoryImpl() {
        this.rooms = new HashSet<>();
    }

    private Room isRoom(String roomType) {
        return this.rooms.stream()
                .filter(room -> room.getRoomType().trim().equals(roomType))
                .findAny()
                .orElse(null);
    }

    public static RoomRepositoryImpl getRepository() {
        if (repository == null) repository = new RoomRepositoryImpl();
        return repository;
    }

    public Room create(Room room) {
        this.rooms.add(room);
        return room;
    }

    public Room read(final String roomType){
        Room room = isRoom(roomType);
        return room;
    }

    public void delete(String roomType) {
        Room room = isRoom(roomType);
        if (room != null) this.rooms.remove(room);
    }

    public Room update(Room room) {
        Room toDelete = isRoom(room.getRoomType());
        if(toDelete != null) {
            this.rooms.remove(toDelete);
            return create(room);
        }
        return null;
    }

    public Set<Room> getAll(){
        return this.rooms;
    }
}
