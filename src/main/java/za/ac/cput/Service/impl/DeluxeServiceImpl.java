package za.ac.cput.Service.impl;

import za.ac.cput.Domain.Content.Deluxe;
import za.ac.cput.Repository.DeluxeRepository;
import za.ac.cput.Repository.Implementation.DeluxeRepositoryImpl;
import za.ac.cput.Service.DeluxeService;

import java.util.Map;

public class DeluxeServiceImpl implements DeluxeService {

    private DeluxeServiceImpl service = null;
    private DeluxeRepository repository;

    private DeluxeServiceImpl(){
        this.repository = DeluxeRepositoryImpl.getRepository();
    }

    public DeluxeService getService(){
        if (service == null) service = new DeluxeServiceImpl();
        return null;
    }

    @Override
    public Deluxe create(Deluxe deluxe) {
        return this.repository.create(deluxe);
    }

    @Override
    public Deluxe update(Deluxe deluxe) {
        return this.repository.update(deluxe);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Deluxe read(String s) {
        return this.repository.read(s);
    }

    public Map<Deluxe, Deluxe> getAll() {
        return this.repository.getAll();
    }
}
