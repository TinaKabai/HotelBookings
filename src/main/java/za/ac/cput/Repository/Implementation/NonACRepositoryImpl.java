package za.ac.cput.Repository.Implementation;

import za.ac.cput.Domain.Content.NonAC;
import za.ac.cput.Repository.NonACRepository;

import java.util.HashSet;
import java.util.Set;

public class NonACRepositoryImpl implements NonACRepository {

    private static NonACRepositoryImpl repository = null;
    private Set<NonAC> nonACs;

    private NonACRepositoryImpl() {
        this.nonACs = new HashSet<NonAC>();
    }

    public static NonACRepositoryImpl getRepository() {
        if (repository == null) repository = new NonACRepositoryImpl();
        return repository;
    }


    public NonAC create(NonAC nonAC) {
        this.nonACs.add(nonAC);
        return nonAC;
    }

    public NonAC read(String roomType) {
        // find the course that matches the id and return it if exist
        return null;
    }

    public void delete(String roomType) {
        // find the course, delete it if it exist
    }

    public NonAC update(NonAC nonAC) {
        // find the course, update it and delete it if it exists
        return nonAC;
    }
    public Set<NonAC> getAll(){
        return this.nonACs;
    }
}
