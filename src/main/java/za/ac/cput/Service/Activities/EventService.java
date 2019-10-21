package za.ac.cput.Service.Activities;

import za.ac.cput.Domain.Activites.Event;
import za.ac.cput.Service.GenIService;

import java.util.List;

public interface EventService extends GenIService<Event, String> {

    Event retrieveById(String id);
    List<Event> getAll();
}
