package za.ac.cput.Service.Content.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Content.Hotel;
import za.ac.cput.Repository.content.HotelRepository;
import za.ac.cput.Service.Content.HotelService;

import java.util.List;
import java.util.Set;

@Service
public class HotelServiceImpl implements HotelService {

    private static HotelService service = null;

    @Autowired
    private HotelRepository repo;

    private HotelServiceImpl(){

    }

    public static HotelService getService()
    {
        if(service == null) service = new HotelServiceImpl();
        return service;
    }

    @Override
    public Hotel retrieveById(String id)
    {
        List<Hotel> hotels = getAll();
        for(Hotel h: hotels)
        {
            if (h.getHotelName().equals(id)) return h;
        }
        return null;
    }

    @Override
    public List<Hotel> getAll() {
        return this.repo.findAll();
    }

    public Hotel create(Hotel hotel) {
        return this.repo.save(hotel);
    }


    public Hotel read(String s) {
        return this.repo.findById(s).orElse(null);
    }


    public Hotel update(Hotel hotel) {
        return this.repo.save(hotel);
    }

    @Override
    public void delete(String s) {
        this.repo.deleteById(s);
    }
}
