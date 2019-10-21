package za.ac.cput.Service.Content.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Content.Room;
import za.ac.cput.Repository.content.RoomRepository;
import za.ac.cput.Service.Content.RoomService;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    private static RoomService service = null;

    @Autowired
    private RoomRepository repo;

    private RoomServiceImpl(){

    }

    public static RoomService getService()
    {
        if(service == null) service = new RoomServiceImpl();
        return service;
    }

    @Override
    public Room retrieveById(String id)
    {
        List<Room> rooms = getAll();
        for(Room r: rooms)
        {
            if (r.getRoomType().equals(id)) return r;
        }
        return null;
    }

    @Override
    public List<Room> getAll() {
        return this.repo.findAll();
    }

    public Room create(Room room) {
        return this.repo.save(room);
    }


    public Room read(String s) {
        return this.repo.findById(s).orElse(null);
    }


    public Room update(Room room) {
        return this.repo.save(room);
    }

    @Override
    public void delete(String s) {
        this.repo.deleteById(s);
    }
}
