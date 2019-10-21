package za.ac.cput.Service.Content.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Content.Deluxe;
import za.ac.cput.Repository.content.DeluxeRepository;
import za.ac.cput.Service.Content.DeluxeService;

import java.util.List;

@Service
public class DeluxeServiceImpl implements DeluxeService {

    private static DeluxeService service = null;

    @Autowired
    private DeluxeRepository repo;

    private DeluxeServiceImpl(){

    }

    public static DeluxeService getService()
    {
        if(service == null) service = new DeluxeServiceImpl();
        return service;
    }

    @Override
    public Deluxe retrieveById(String id)
    {
        List<Deluxe> deluxes = getAll();
        for(Deluxe d: deluxes)
        {
            if (d.getRoomStatus().equals(id)) return d;
        }
        return null;
    }

    @Override
    public List<Deluxe> getAll() {
        return this.repo.findAll();
    }

    public Deluxe create(Deluxe deluxe) {
        return this.repo.save(deluxe);
    }


    public Deluxe read(String s) {
        return this.repo.findById(s).orElse(null);
    }


    public Deluxe update(Deluxe deluxe) {
        return this.repo.save(deluxe);
    }

    @Override
    public void delete(String s) {
        this.repo.deleteById(s);
    }
}
