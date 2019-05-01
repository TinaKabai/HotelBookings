package za.ac.cput.Repository.Implementation;

import za.ac.cput.Domain.Content.Room;

import java.util.HashSet;
import java.util.Set;

public class RoomRepositoryImpl {

    private static RoomRepositoryImpl repository = null;
    private Set<Room> rooms;

    private RoomRepositoryImpl() {
        this.rooms = new HashSet<Room>();
    }

    public static RoomRepositoryImpl getRepository() {
        if (repository == null) repository = new RoomRepositoryImpl();
        return repository;
    }

    public Room create(Room room) {
        this.rooms.add(room);
        return room;
    }

    public Room read(int roomNo) {
        // find the course that matches the id and return it if exist
        return null;
    }

    public void delete(int roomNo) {
        // find the course, delete it if it exist
    }

    public Room update(Room room) {
        // find the course, update it and delete it if it exists
        return room;
    }

    public Set<Room> getAll(){
        return this.rooms;
    }
}
