package za.ac.cput.Service.Activities.implementations;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Activites.Sport;
import za.ac.cput.Repository.activities.SportRepository;
import za.ac.cput.Service.Activities.SportService;

import java.util.List;

@Service
public class SportServiceImpl implements SportService {

    private static SportService service = null;

    @Autowired
    private SportRepository repo;

    private SportServiceImpl(){

    }

    public static SportService getService()
    {
        if(service == null) service = new SportServiceImpl();
        return service;
    }

    @Override
    public Sport retrieveById(String id)
    {
        List<Sport> sports = getAll();
        for(Sport s: sports)
        {
            if (s.getSportName().equals(id)) return s;
        }
        return null;
    }

    @Override
    public List<Sport> getAll() {
        return this.repo.findAll();
    }

    public Sport create(Sport sport) {
        return this.repo.save(sport);
    }


    public Sport read(String s) {
        return this.repo.findById(s).orElse(null);
    }


    public Sport update(Sport sport) {
        return this.repo.save(sport);
    }


    public void delete(String s) {
        this.repo.deleteById(s);
    }
}
