package za.ac.cput.Service;

import za.ac.cput.Domain.Activites.Event;

import java.util.Map;

public interface EventService extends IService<Event, String> {

    Map<Event, Event> getAll();
}
