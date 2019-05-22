package za.ac.cput.Service.impl;

import za.ac.cput.Domain.Content.Guest;
import za.ac.cput.Repository.GuestRepository;
import za.ac.cput.Repository.Implementation.GuestRepositoryImpl;
import za.ac.cput.Service.GuestService;

import java.util.Map;

public class GuestServiceImpl implements GuestService {

    private GuestServiceImpl service = null;
    private GuestRepository repository;

    private GuestServiceImpl(){
        this.repository = GuestRepositoryImpl.getRepository();
    }

    public GuestService getService(){
        if (service == null) service = new GuestServiceImpl();
        return null;
    }

    @Override
    public Guest create(Guest guest) {
        return this.repository.create(guest);
    }

    @Override
    public Guest update(Guest guest) {
        return this.repository.update(guest);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Guest read(String s) {
        return this.repository.read(s);
    }

    public Map<Guest, Guest> getAll() {
        return this.repository.getAll();
    }
}
