package za.ac.cput.Service.impl;

import za.ac.cput.Domain.Content.NonAC;
import za.ac.cput.Repository.Implementation.NonACRepositoryImpl;
import za.ac.cput.Repository.NonACRepository;
import za.ac.cput.Service.NonACService;

import java.util.Set;

public class NonACServiceImpl implements NonACService {

    private NonACServiceImpl service = null;
    private NonACRepository repository;

    private NonACServiceImpl(){
        this.repository = NonACRepositoryImpl.getRepository();
    }

    public NonACService getService(){
        if (service == null) service = new NonACServiceImpl();
        return null;
    }

    @Override
    public NonAC create(NonAC nonAC) {
        return this.repository.create(nonAC);
    }

    @Override
    public NonAC update(NonAC nonAC) {
        return this.repository.update(nonAC);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public NonAC read(String s) {
        return this.repository.read(s);
    }

    public Set<NonAC> getAll() {
        return this.repository.getAll();
    }
}
