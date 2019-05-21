package za.ac.cput.Repository;

import za.ac.cput.Domain.Content.Demographic;

import java.util.Map;

public interface DemographicRepository extends IRepository<Demographic, String> {

    Map<Demographic, Demographic> getAll();
}
