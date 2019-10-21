package za.ac.cput.Repository.activities.implementations;

/*import org.springframework.stereotype.Repository;
import za.ac.cput.Domain.Activites.Event;
import za.ac.cput.Repository.activities.EventRepository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Repository*/
/*public class EventRepositoryImpl implements EventRepository {

    private static EventRepositoryImpl repository = null;
    private Map<Event, Event> events;

    private EventRepositoryImpl() {
        this.events = new HashMap<>();
    }

    private Event theEvent(String eventName) {
        return this.events.values().stream()
                .filter(event -> event.getEvName().trim().equals(eventName))
                .findAny()
                .orElse(null);
    }

    public static EventRepositoryImpl getRepository() {
        if (repository == null) repository = new EventRepositoryImpl();
        return repository;
    }

    public Event create(Event event) {
        this.events.put(event, event);
        return event;
    }

    public Event read(final String eventName){
        Event event = theEvent(eventName);
        return event;
    }

    public void delete(String eventName) {
        Event event = theEvent(eventName);
        if (event != null) this.events.remove(event);
    }

    public Event update(Event event) {
        Event toDelete = theEvent(event.getEvName());
        if(toDelete != null) {
            this.events.remove(toDelete);
            return create(event);
        }
        return null;
    }

    public Map<Event, Event> getAll(){
        return this.events;
    }
}*/

