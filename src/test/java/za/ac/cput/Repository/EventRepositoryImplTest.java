package za.ac.cput.Repository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import za.ac.cput.Domain.Activites.Event;
import za.ac.cput.Factory.EventFactory;
import za.ac.cput.Repository.Implementation.EventRepositoryImpl;

import java.util.Map;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EventRepositoryImplTest {

    private EventRepository repository;

    private Event event;

    @Before
    public void setUp() throws Exception {

        this.repository = (EventRepositoryImpl) EventRepositoryImpl.getRepository();

        this.event = EventFactory.events("Rugby", "Cape Sun Hotel", "10 May 2019", 100.00);
    }

    @Test
    public void d_getAll() {
        Map<Event, Event> admin = this.repository.getAll();

        System.out.println("In getAll, all = " + admin);
    }

    @Test
    public void create() {

        Event created = this.repository.create(this.event);

        System.out.println("In create, created = " + created);

        Assert.assertNotNull(created);

        Assert.assertSame(created, this.event);
    }

    @Test
    public void read() {

        Event read = this.repository.read(event.getEvName());

        System.out.println("In read, read = " + read);

        d_getAll();
        Assert.assertEquals(read, event);
    }

    @Test
    public void update() {

        String newEvent = "Dancing";

        Event updated = new Event.Builder().event(newEvent).build();

        System.out.println("In update, about_to_updated = " + updated);

        this.repository.update(updated);

        Assert.assertEquals(newEvent, updated.getEvName());
        d_getAll();
    }

    @Test
    public void delete() {

        this.repository.delete(event.getEvName());
        d_getAll();
    }

}