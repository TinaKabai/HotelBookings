package za.ac.cput.Service.impl;

import za.ac.cput.Domain.Content.Services;
import za.ac.cput.Repository.Implementation.ServicesRepositoryImpl;
import za.ac.cput.Repository.ServicesRepository;
import za.ac.cput.Service.ServicesService;

import java.util.Set;

public class ServicesServiceImpl implements ServicesService  {

    private ServicesServiceImpl service = null;
    private ServicesRepository repository;

    private ServicesServiceImpl(){
        this.repository = ServicesRepositoryImpl.getRepository();
    }

    public ServicesService getService(){
        if (service == null) service = new ServicesServiceImpl();
        return null;
    }

    @Override
    public Services create(Services services) {
        return this.repository.create(services);
    }

    @Override
    public Services update(Services services) {
        return this.repository.update(services);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Services read(String s) {
        return this.repository.read(s);
    }

    public Set<Services> getAll() {
        return this.repository.getAll();
    }
}
