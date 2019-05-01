package za.ac.cput.Repository;

import za.ac.cput.Domain.Content.Services;

import java.util.Set;

public interface ServicesRepository extends IRepository<Services, String> {

    Set<Services> getAll();
}
