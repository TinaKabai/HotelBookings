package za.ac.cput.Service.impl;

import za.ac.cput.Domain.Activites.Sport;
import za.ac.cput.Repository.Implementation.SportRepositoryImpl;
import za.ac.cput.Repository.SportRepository;
import za.ac.cput.Service.SportService;

import java.util.Set;

public class SportServiceImpl implements SportService {

    private SportServiceImpl service = null;
    private SportRepository repository;

    private SportServiceImpl(){
        this.repository = SportRepositoryImpl.getRepository();
    }

    public SportService getService(){
        if (service == null) service = new SportServiceImpl();
        return null;
    }

    @Override
    public Sport create(Sport sport) {
        return this.repository.create(sport);
    }

    @Override
    public Sport update(Sport sport) {
        return this.repository.update(sport);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Sport read(String s) {
        return this.repository.read(s);
    }

    public Set<Sport> getAll() {
        return this.repository.getAll();
    }
}
