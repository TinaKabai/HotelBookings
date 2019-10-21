package za.ac.cput.Service.Content.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Content.NonAC;
import za.ac.cput.Repository.content.NonACRepository;
import za.ac.cput.Service.Content.NonACService;

import java.util.List;

@Service
public class NonACServiceImpl implements NonACService {

    private static NonACService service = null;

    @Autowired
    private NonACRepository repo;

    private NonACServiceImpl(){

    }

    public static NonACService getService()
    {
        if(service == null) service = new NonACServiceImpl();
        return service;
    }

    @Override
    public NonAC retrieveById(String id)
    {
        List<NonAC> nonACs = getAll();
        for(NonAC n: nonACs)
        {
            if (n.getRoomStatus().equals(id)) return n;
        }
        return null;
    }

    @Override
    public List<NonAC> getAll() {
        return this.repo.findAll();
    }

    public NonAC create(NonAC nonAC) {
        return this.repo.save(nonAC);
    }


    public NonAC read(String s) {
        return this.repo.findById(s).orElse(null);
    }


    public NonAC update(NonAC nonAC) {
        return this.repo.save(nonAC);
    }

    @Override
    public void delete(String s) {
        this.repo.deleteById(s);
    }
}
