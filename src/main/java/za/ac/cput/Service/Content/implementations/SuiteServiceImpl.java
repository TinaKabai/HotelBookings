package za.ac.cput.Service.Content.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Content.Suite;
import za.ac.cput.Repository.content.SuiteRepository;
import za.ac.cput.Service.Content.SuiteService;

import java.util.List;

@Service
public class SuiteServiceImpl implements SuiteService {

    private static SuiteService service = null;

    @Autowired
    private SuiteRepository repo;

    private SuiteServiceImpl(){

    }

    public static SuiteService getService()
    {
        if(service == null) service = new SuiteServiceImpl();
        return service;
    }

    @Override
    public Suite retrieveById(String id)
    {
        List<Suite> suites = getAll();
        for(Suite s: suites)
        {
            if (s.getRoomStatus().equals(id)) return s;
        }
        return null;
    }

    @Override
    public List<Suite> getAll() {
        return this.repo.findAll();
    }

    public Suite create(Suite suite) {
        return this.repo.save(suite);
    }


    public Suite read(String s) {
        return this.repo.findById(s).orElse(null);
    }


    public Suite update(Suite suite) {
        return this.repo.save(suite);
    }

    @Override
    public void delete(String s) {
        this.repo.deleteById(s);
    }
}
