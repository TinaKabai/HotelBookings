package za.ac.cput.Repository.Implementation;

import za.ac.cput.Domain.Activites.Sport;
import za.ac.cput.Repository.SportRepository;

import java.util.HashSet;
import java.util.Set;

public class SportRepositoryImpl implements SportRepository {

    private static SportRepositoryImpl repository = null;
    private Set<Sport> sports;

    private SportRepositoryImpl() {
        this.sports = new HashSet<Sport>();
    }

    public static SportRepositoryImpl getRepository() {
        if (repository == null) repository = new SportRepositoryImpl();
        return repository;
    }
    public Sport create(Sport sport) {
        this.sports.add(sport);
        return sport;
    }

    public Sport read(String sportName) {
        // find the course that matches the id and return it if exist
        return null;
    }

    public void delete(String sportName) {
        // find the course, delete it if it exist
    }

    public Sport update(Sport sport) {
        // find the course, update it and delete it if it exists
        return sport;
    }

    public Set<Sport> getAll(){
        return this.sports;
    }
}
