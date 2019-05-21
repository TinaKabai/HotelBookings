package za.ac.cput.Service.impl;

import za.ac.cput.Domain.Activites.Event;
import za.ac.cput.Repository.EventRepository;
import za.ac.cput.Repository.Implementation.EventRepositoryImpl;
import za.ac.cput.Service.EventService;

import java.util.Map;

public class EventServiceImpl {

    private EventServiceImpl service = null;
    private EventRepository repository;

    private EventServiceImpl(){
        this.repository = EventRepositoryImpl.getRepository();
    }

    public EventService getService(){
        if (service == null) service = new EventServiceImpl();
        return null;
    }

    //@Override
    public Event create(Event event) {
        return this.repository.create(event);
    }

    //@Override
    public Event update(Event event) {
        return this.repository.update(event);
    }

    //@Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    //@Override
    public Event read(String s) {
        return this.repository.read(s);
    }

    //@Override
    public Map<Event, Event> getAllHotelEvents() {
        Map<Event, Event> events = getAll();
        return null;
    }

    //@Override
    public Map<Event, Event> getAll() {
        return this.repository.getAll();
    }
}
