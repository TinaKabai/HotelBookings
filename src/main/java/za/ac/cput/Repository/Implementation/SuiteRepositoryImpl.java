package za.ac.cput.Repository.Implementation;

import za.ac.cput.Domain.Content.Suite;
import za.ac.cput.Repository.SuiteRepository;

import java.util.HashSet;
import java.util.Set;

public class SuiteRepositoryImpl implements SuiteRepository {

    private static SuiteRepositoryImpl repository = null;
    private Set<Suite> suites;

    private SuiteRepositoryImpl() {
        this.suites = new HashSet<>();
    }

    private Suite isSuite(String roomType) {
        return this.suites.stream()
                .filter(suite -> suite.getRoomType().trim().equals(roomType))
                .findAny()
                .orElse(null);
    }

    public static SuiteRepositoryImpl getRepository() {
        if (repository == null) repository = new SuiteRepositoryImpl();
        return repository;
    }
    public Suite create(Suite suite) {
        this.suites.add(suite);
        return suite;
    }

    public Suite read(final String roomType){
        Suite suite = isSuite(roomType);
        return suite;
    }

    public void delete(String roomType) {
        Suite suite = isSuite(roomType);
        if (suite != null) this.suites.remove(suite);
    }

    public Suite update(Suite suite) {
        Suite toDelete = isSuite(suite.getRoomType());
        if(toDelete != null) {
            this.suites.remove(toDelete);
            return create(suite);
        }
        return null;
    }
    public Set<Suite> getAll(){
        return this.suites;
    }
}
