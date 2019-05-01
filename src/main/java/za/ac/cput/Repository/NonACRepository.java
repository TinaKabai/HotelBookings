package za.ac.cput.Repository;

import za.ac.cput.Domain.Content.NonAC;

import java.util.Set;

public interface NonACRepository extends IRepository<NonAC, String> {

    Set<NonAC> getAll();
}
