package za.ac.cput.Repository;

import za.ac.cput.Domain.Activites.Event;

import java.util.Map;

public interface EventRepository extends IRepository<Event, String> {

    Map<Event, Event> getAll();
}
