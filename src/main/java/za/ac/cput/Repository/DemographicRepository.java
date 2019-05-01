package za.ac.cput.Repository;

import za.ac.cput.Domain.Content.Demographic;

import java.util.Set;

public interface DemographicRepository extends IRepository<Demographic, String> {

    Set<Demographic> getAll();
}
