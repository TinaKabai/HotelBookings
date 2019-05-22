package za.ac.cput.Repository.Implementation;

import za.ac.cput.Domain.Activites.Sport;
import za.ac.cput.Repository.SportRepository;

import java.util.HashSet;
import java.util.Set;

public class SportRepositoryImpl implements SportRepository {

    private static SportRepositoryImpl repository = null;
    private Set<Sport> sports;

    private SportRepositoryImpl() {
        this.sports = new HashSet<>();
    }

    private Sport theSport(String sportName) {
        return this.sports.stream()
                .filter(sport -> sport.getSportName().trim().equals(sportName))
                .findAny()
                .orElse(null);
    }

    public static SportRepositoryImpl getRepository() {
        if (repository == null) repository = new SportRepositoryImpl();
        return repository;
    }
    public Sport create(Sport sport) {
        this.sports.add(sport);
        return sport;
    }

    public Sport read(final String sportName){
        Sport sport = theSport(sportName);
        return sport;
    }

    public void delete(String sportName) {
        Sport sport = theSport(sportName);
        if (sport != null) this.sports.remove(sport);
    }

    public Sport update(Sport sport) {
        Sport toDelete = theSport(sport.getSportName());
        if(toDelete != null) {
            this.sports.remove(toDelete);
            return create(sport);
        }
        return null;
    }

    public Set<Sport> getAll(){
        return this.sports;
    }
}
