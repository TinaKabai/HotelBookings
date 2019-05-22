package za.ac.cput.controller;


import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import za.ac.cput.Domain.Activites.Event;
import za.ac.cput.Factory.EventFactory;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class EventControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/event";

    @Test
    public void testGetAllEvents() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetEventById() {
        Event event = restTemplate.getForObject(baseURL + "/event/1", Event.class);
        System.out.println(event.getEvName());
        assertNotNull(event);
    }

    @Ignore
    public void testCreateEvent() {
        Event event = EventFactory.events("Rugby", "Cape Sun Hotel", "10 May 2019", 100.00);

        ResponseEntity<Event> postResponse = restTemplate.postForEntity(baseURL + "/create", event, Event.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateEvent() {
        int id = 1;
        Event event = restTemplate.getForObject(baseURL + "/event/" + id, Event.class);

        restTemplate.put(baseURL + "/events/" + id, event);
        Event updatedEvent = restTemplate.getForObject(baseURL + "/Event/" + id, Event.class);
        assertNotNull(updatedEvent);
    }

    @Ignore
    public void testDeleteEvent() {
        int id = 2;
        Event event = restTemplate.getForObject(baseURL + "/events/" + id, Event.class);
        assertNotNull(event);
        restTemplate.delete(baseURL + "/events/" + id);
        try {
            event = restTemplate.getForObject(baseURL + "/events/" + id, Event.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

}