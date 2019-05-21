package za.ac.cput.Repository;

import za.ac.cput.Domain.Content.Deluxe;

import java.util.Map;

public interface DeluxeRepository extends IRepository<Deluxe, String> {

    Map<Deluxe, Deluxe> getAll();
}
