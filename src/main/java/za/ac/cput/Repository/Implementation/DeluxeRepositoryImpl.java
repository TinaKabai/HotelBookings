package za.ac.cput.Repository.Implementation;

import za.ac.cput.Domain.Content.Deluxe;
import za.ac.cput.Repository.DeluxeRepository;

import java.util.HashSet;
import java.util.Set;

public class DeluxeRepositoryImpl implements DeluxeRepository {

    private static DeluxeRepositoryImpl repository = null;
    private Set<Deluxe> deluxes;

    private DeluxeRepositoryImpl() {
        this.deluxes = new HashSet<Deluxe>();
    }

    public static DeluxeRepositoryImpl getRepository() {
        if (repository == null) repository = new DeluxeRepositoryImpl();
        return repository;
    }


    public Deluxe create(Deluxe deluxe) {
        this.deluxes.add(deluxe);
        return deluxe;
    }

    public Deluxe read(String roomType) {
        // find the course that matches the id and return it if exist
        return null;
    }

    public void delete(String roomType) {
        // find the course, delete it if it exist
    }

    public Deluxe update(Deluxe deluxe) {
        // find the course, update it and delete it if it exists
        return deluxe;
    }
    public Set<Deluxe> getAll(){
        return this.deluxes;
    }
}
