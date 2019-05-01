package za.ac.cput.Repository.Implementation;

import za.ac.cput.Domain.Content.Services;
import za.ac.cput.Repository.ServicesRepository;

import java.util.HashSet;
import java.util.Set;

public class ServicesRepositoryImpl implements ServicesRepository {

    private static ServicesRepositoryImpl repository = null;
    private Set<Services> services;

    private ServicesRepositoryImpl() {
        this.services = new HashSet<Services>();
    }

    public static ServicesRepositoryImpl getRepository() {
        if (repository == null) repository = new ServicesRepositoryImpl();
        return repository;
    }
    public Services create(Services services1) {
        this.services.add(services1);
        return services1;
    }

    public Services read(String servName) {
        // find the course that matches the id and return it if exist
        return null;
    }

    public void delete(String servName) {
        // find the course, delete it if it exist
    }

    public Services update(Services services1) {
        // find the course, update it and delete it if it exists
        return services1;
    }

    public Set<Services> getAll(){
        return this.services;
    }
}
