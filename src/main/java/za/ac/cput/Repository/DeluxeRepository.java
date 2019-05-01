package za.ac.cput.Repository;

import za.ac.cput.Domain.Content.Deluxe;

import java.util.Set;

public interface DeluxeRepository extends IRepository<Deluxe, String> {

    Set<Deluxe> getAll();
}
