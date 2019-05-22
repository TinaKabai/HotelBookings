package za.ac.cput.Service.impl;

import za.ac.cput.Domain.Content.Demographic;
import za.ac.cput.Repository.DemographicRepository;
import za.ac.cput.Repository.Implementation.DemographicRepositoryImpl;
import za.ac.cput.Service.DemographicService;

import java.util.Map;

public class DemographicServiceImpl implements DemographicService {

    private DemographicServiceImpl service = null;
    private DemographicRepository repository;

    private DemographicServiceImpl(){
        this.repository = DemographicRepositoryImpl.getRepository();
    }

    public DemographicService getService(){
        if (service == null) service = new DemographicServiceImpl();
        return null;
    }

    @Override
    public Demographic create(Demographic demographic) {
        return this.repository.create(demographic);
    }

    @Override
    public Demographic update(Demographic demographic) {
        return this.repository.update(demographic);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Demographic read(String s) {
        return this.repository.read(s);
    }

    public Map<Demographic, Demographic> getAll() {
        return this.repository.getAll();
    }
}
