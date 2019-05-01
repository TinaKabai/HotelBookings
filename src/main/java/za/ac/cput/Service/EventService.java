package za.ac.cput.Service;

import za.ac.cput.Domain.Activites.Event;

import java.util.Set;

public interface EventService extends IService<Event, String> {

    Set<Event> getAllAppDevCourses();
    Set<Event> getAll();
}
