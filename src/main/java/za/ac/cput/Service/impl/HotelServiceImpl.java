package za.ac.cput.Service.impl;

import za.ac.cput.Domain.Content.Hotel;
import za.ac.cput.Repository.HotelRepository;
import za.ac.cput.Repository.Implementation.HotelRepositoryImpl;
import za.ac.cput.Service.HotelService;

import java.util.Set;

public class HotelServiceImpl implements HotelService {

    private HotelServiceImpl service = null;
    private HotelRepository repository;

    private HotelServiceImpl(){
        this.repository = HotelRepositoryImpl.getRepository();
    }

    public HotelService getService(){
        if (service == null) service = new HotelServiceImpl();
        return null;
    }

    @Override
    public Hotel create(Hotel hotel) {
        return this.repository.create(hotel);
    }

    @Override
    public Hotel update(Hotel hotel) {
        return this.repository.update(hotel);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Hotel read(String s) {
        return this.repository.read(s);
    }

    public Set<Hotel> getAll() {
        return this.repository.getAll();
    }
}
