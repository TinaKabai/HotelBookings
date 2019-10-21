package za.ac.cput.Service.Activities.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Activites.Event;
import za.ac.cput.Repository.activities.EventRepository;
import za.ac.cput.Service.Activities.EventService;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    private static EventService service = null;

    @Autowired
    private EventRepository repo;

    private EventServiceImpl(){

    }

    public static EventService getService()
    {
        if(service == null) service = new EventServiceImpl();
        return service;
    }

    @Override
    public Event retrieveById(String id)
    {
        List<Event> events = getAll();
        for(Event e: events)
        {
            if (e.getEvName().equals(id)) return e;
        }
        return null;
    }

    @Override
    public List<Event> getAll() {
        return this.repo.findAll();
    }

    public Event create(Event event) {
        return this.repo.save(event);
    }


    public Event read(String s) {
        return this.repo.findById(s).orElse(null);
    }


    public Event update(Event event) {
        return this.repo.save(event);
    }


    public void delete(String s) {
        this.repo.deleteById(s);
    }
}
