package za.ac.cput.Service.Content.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Content.Demographic;
import za.ac.cput.Repository.content.DemographicRepository;
import za.ac.cput.Service.Content.DemographicService;

import java.util.List;

@Service
public class DemographicServiceImpl implements DemographicService {

    private static DemographicService service = null;

    @Autowired
    private DemographicRepository repo;

    private DemographicServiceImpl(){

    }

    public static DemographicService getService()
    {
        if(service == null) service = new DemographicServiceImpl();
        return service;
    }

    @Override
    public Demographic retrieveById(String id)
    {
        List<Demographic> demographics = getAll();
        for(Demographic d: demographics)
        {
            if (d.getGender().equals(id)) return d;
        }
        return null;
    }

    @Override
    public List<Demographic> getAll() {
        return this.repo.findAll();
    }

    public Demographic create(Demographic demographic) {
        return this.repo.save(demographic);
    }


    public Demographic read(String s) {
        return this.repo.findById(s).orElse(null);
    }


    public Demographic update(Demographic demographic) {
        return this.repo.save(demographic);
    }

    @Override
    public void delete(String s) {
        this.repo.deleteById(s);
    }
}
