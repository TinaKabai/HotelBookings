package za.ac.cput.Service.impl;

import za.ac.cput.Domain.Content.Suite;
import za.ac.cput.Repository.Implementation.SuiteRepositoryImpl;
import za.ac.cput.Repository.SuiteRepository;
import za.ac.cput.Service.SuiteService;

import java.util.Set;

public class SuiteServiceImpl implements SuiteService {

    private SuiteServiceImpl service = null;
    private SuiteRepository repository;

    private SuiteServiceImpl(){
        this.repository = SuiteRepositoryImpl.getRepository();
    }

    public SuiteService getService(){
        if (service == null) service = new SuiteServiceImpl();
        return null;
    }

    @Override
    public Suite create(Suite suite) {
        return this.repository.create(suite);
    }

    @Override
    public Suite update(Suite suite) {
        return this.repository.update(suite);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Suite read(String s) {
        return this.repository.read(s);
    }

    public Set<Suite> getAll() {
        return this.repository.getAll();
    }
}
