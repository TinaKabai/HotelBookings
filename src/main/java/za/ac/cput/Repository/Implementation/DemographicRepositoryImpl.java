package za.ac.cput.Repository.Implementation;

import za.ac.cput.Domain.Content.Demographic;
import za.ac.cput.Repository.DemographicRepository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DemographicRepositoryImpl implements DemographicRepository {

    private static DemographicRepositoryImpl repository = null;
    private Map<Demographic, Demographic> demographics;

    private DemographicRepositoryImpl() {
        this.demographics = new HashMap<>();
    }

    private Demographic theDemographic(String race) {
        return this.demographics.values().stream()
                .filter(demographic -> demographic.getRace().trim().equals(race))
                .findAny()
                .orElse(null);
    }

    public static DemographicRepositoryImpl getRepository() {
        if (repository == null) repository = new DemographicRepositoryImpl();
        return repository;
    }
    public Demographic create(Demographic demographic) {
        this.demographics.put(demographic, demographic);
        return demographic;
    }
    public Demographic read(final String race){
        Demographic demographic = theDemographic(race);
        return demographic;
    }

    public void delete(String race) {
        Demographic demographic = theDemographic(race);
        if (race != null) this.demographics.remove(demographic);
    }

    public Demographic update(Demographic demographic) {
        Demographic toDelete = theDemographic(demographic.getRace());
        if(toDelete != null) {
            this.demographics.remove(toDelete);
            return create(demographic);
        }
        return null;
    }

    public Map<Demographic, Demographic> getAll(){
        return this.demographics;
    }
}
