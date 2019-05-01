package za.ac.cput.Repository;

import za.ac.cput.Domain.Activites.Sport;

import java.util.Set;

public interface SportRepository extends IRepository<Sport, String> {

    Set<Sport> getAll();
}
