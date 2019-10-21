package za.ac.cput.Service.Content.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Content.Services;
import za.ac.cput.Repository.content.ServicesRepository;
import za.ac.cput.Service.Content.ServicesService;

import java.util.List;

@Service
public class ServicesServiceImpl implements ServicesService  {

    private static ServicesService service = null;

    @Autowired
    private ServicesRepository repo;

    private ServicesServiceImpl(){

    }

    public static ServicesService getService()
    {
        if(service == null) service = new ServicesServiceImpl();
        return service;
    }

    @Override
    public Services retrieveById(String id)
    {
        List<Services> serv = getAll();
        for(Services s: serv)
        {
            if (s.getServName().equals(id)) return s;
        }
        return null;
    }

    @Override
    public List<Services> getAll() {
        return this.repo.findAll();
    }

    public Services create(Services services) {
        return this.repo.save(services);
    }


    public Services read(String s) {
        return this.repo.findById(s).orElse(null);
    }


    public Services update(Services services) {
        return this.repo.save(services);
    }

    @Override
    public void delete(String s) {
        this.repo.deleteById(s);
    }
}
