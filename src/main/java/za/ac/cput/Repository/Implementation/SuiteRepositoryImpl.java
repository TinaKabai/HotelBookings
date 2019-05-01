package za.ac.cput.Repository.Implementation;

import za.ac.cput.Domain.Content.Suite;
import za.ac.cput.Repository.SuiteRepository;

import java.util.HashSet;
import java.util.Set;

public class SuiteRepositoryImpl implements SuiteRepository {

    private static SuiteRepositoryImpl repository = null;
    private Set<Suite> suites;

    private SuiteRepositoryImpl() {
        this.suites = new HashSet<Suite>();
    }

    public static SuiteRepositoryImpl getRepository() {
        if (repository == null) repository = new SuiteRepositoryImpl();
        return repository;
    }
    public Suite create(Suite suite) {
        this.suites.add(suite);
        return suite;
    }

    public Suite read(String roomType) {
        // find the course that matches the id and return it if exist
        return null;
    }

    public void delete(String roomType) {
        // find the course, delete it if it exist
    }

    public Suite update(Suite suite) {
        // find the course, update it and delete it if it exists
        return suite;
    }
    public Set<Suite> getAll(){
        return this.suites;
    }
}
