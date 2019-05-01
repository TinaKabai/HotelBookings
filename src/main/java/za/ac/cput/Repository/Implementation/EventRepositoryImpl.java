package za.ac.cput.Repository.Implementation;

import za.ac.cput.Domain.Activites.Event;
import za.ac.cput.Repository.EventRepository;

import java.util.HashSet;
import java.util.Set;

public class EventRepositoryImpl implements EventRepository {

    private static EventRepositoryImpl repository = null;
    private Set<Event> events;

    private EventRepositoryImpl() {
        this.events = new HashSet<Event>();
    }

    public static EventRepositoryImpl getRepository() {
        if (repository == null) repository = new EventRepositoryImpl();
        return repository;
    }


    public Event create(Event event) {
        this.events.add(event);
        return event;
    }

    public Event read(String evName) {
        // find the course that matches the id and return it if exist
        return null;
    }

    public void delete(String evName) {
        // find the course, delete it if it exist
    }

    public Event update(Event event) {
        // find the course, update it and delete it if it exists
        return event;
    }

    public Set<Event> getAll(){
        return this.events;
    }
}

