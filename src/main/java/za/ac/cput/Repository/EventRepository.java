package za.ac.cput.Repository;

import za.ac.cput.Domain.Activites.Event;

import java.util.Set;

public interface EventRepository extends IRepository<Event, String> {

    Set<Event> getAll();
}
