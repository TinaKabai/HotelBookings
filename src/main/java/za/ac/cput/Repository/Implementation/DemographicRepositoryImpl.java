package za.ac.cput.Repository.Implementation;

import za.ac.cput.Domain.Content.Demographic;
import za.ac.cput.Repository.DemographicRepository;

import java.util.HashSet;
import java.util.Set;

public class DemographicRepositoryImpl implements DemographicRepository {

    private static DemographicRepositoryImpl repository = null;
    private Set<Demographic> demographics;

    private DemographicRepositoryImpl() {
        this.demographics = new HashSet<Demographic>();
    }

    public static DemographicRepositoryImpl getRepository() {
        if (repository == null) repository = new DemographicRepositoryImpl();
        return repository;
    }
    public Demographic create(Demographic demographic) {
        this.demographics.add(demographic);
        return demographic;
    }
    public Demographic read(String race) {
        // find the course that matches the id and return it if exist
        return null;
    }

    public void delete(String race) {
        // find the course, delete it if it exist
    }

    public Demographic update(Demographic demographic) {
        // find the course, update it and delete it if it exists
        return demographic;
    }

    public Set<Demographic> getAll(){
        return this.demographics;
    }
}
