package za.ac.cput.Repository;

import za.ac.cput.Domain.Content.Suite;

import java.util.Set;

public interface SuiteRepository extends IRepository<Suite, String> {

    Set<Suite> getAll();
}
