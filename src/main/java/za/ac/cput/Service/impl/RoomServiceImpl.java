package za.ac.cput.Service.impl;

import za.ac.cput.Domain.Content.Room;
import za.ac.cput.Repository.Implementation.RoomRepositoryImpl;
import za.ac.cput.Repository.RoomRepository;
import za.ac.cput.Service.RoomService;

import java.util.Set;

public class RoomServiceImpl implements RoomService {

    private RoomServiceImpl service = null;
    private RoomRepository repository;

    private RoomServiceImpl(){
        this.repository = RoomRepositoryImpl.getRepository();
    }

    public RoomService getService(){
        if (service == null) service = new RoomServiceImpl();
        return null;
    }

    @Override
    public Room create(Room room) {
        return this.repository.create(room);
    }

    @Override
    public Room update(Room room) {
        return this.repository.update(room);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Room read(String s) {
        return this.repository.read(s);
    }

    public Set<Room> getAll() {
        return this.repository.getAll();
    }
}
