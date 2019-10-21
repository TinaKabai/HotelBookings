package za.ac.cput.Service.Content.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.Domain.Content.Guest;
import za.ac.cput.Repository.content.GuestRepository;
import za.ac.cput.Service.Content.GuestService;

import java.util.List;

public class GuestServiceImpl implements GuestService {

    private static GuestService service = null;

    @Autowired
    private GuestRepository repo;

    private GuestServiceImpl(){

    }

    public static GuestService getService()
    {
        if(service == null) service = new GuestServiceImpl();
        return service;
    }

    @Override
    public Guest retrieveById(String id)
    {
        List<Guest> guests = getAll();
        for(Guest g: guests)
        {
            if (g.getName().equals(id)) return g;
        }
        return null;
    }

    @Override
    public List<Guest> getAll() {
        return this.repo.findAll();
    }

    public Guest create(Guest guest) {
        return this.repo.save(guest);
    }


    public Guest read(String s) {
        return this.repo.findById(s).orElse(null);
    }


    public Guest update(Guest guest) {
        return this.repo.save(guest);
    }

    @Override
    public void delete(String s) {
        this.repo.deleteById(s);
    }
}
