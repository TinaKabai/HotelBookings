package za.ac.cput.Repository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Domain.Activites.Event;
import za.ac.cput.Repository.Implementation.EventRepositoryImpl;

import java.util.Map;
import java.util.Set;

public class EventRepositoryImplTest {
    private EventRepository repository;

    @Before
    public void setUp() throws Exception {
        this.repository = EventRepositoryImpl.getRepository();
    }

    @Test
    public void create() {
        Event event = new Event();
         String evName = "Rugby";
         String hotelName = "Cape Sun Hotel";
         String date = "09 May 2019";
         double costs = 100.00;

         //Assert.assertNotNull("Event is ", event.getEvName());
        this.repository.create(event);
        Assert.assertEquals(evName, event.getEvName());
    }
    @Test
    public void read() {
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void getAll() {
        Map<Event, Event> events = this.repository.getAll();
        Assert.assertEquals(1, events.size());
    }

}