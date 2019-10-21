package za.ac.cput.controller;


import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import za.ac.cput.Domain.Activites.Event;
import za.ac.cput.Factory.EventFactory;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class EventControllerTest {

    @Autowired
    private TestRestTemplate restTempl;
    private String url = "http://localhost:8080/events";

    @Test
    public void create()
    {
        Event event = EventFactory.events("Athletics", "All_Suites Peninsula Hotel",
                                            "10 May 2019", 150.00);
        ResponseEntity<Event> response = restTempl.postForEntity(url + "/create", event, Event.class);
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getBody());
        System.out.println(response.getBody().getEvName());
    }

    @Test
    public void read()
    {
        Event e  = restTempl.getForObject(url + "/read/true", Event.class);
        Assert.assertNotNull(e);
        System.out.println(e.getEvName());
    }

    @Test
    public void update()
    {
        String id = "Athletics";
        Event event  = restTempl.getForObject(url + "/read/" + id, Event.class);

        restTempl.put(url + "/update/" + id, event);
        Event update = restTempl.getForObject(url + "/read/" + id, Event.class);
        Assert.assertNotNull(update);
        System.out.println(update.getEvName());

    }

    @Test
    public void delete()
    {
        String id = "Athletics";
        Event event  = restTempl.getForObject(url + "/read/" + id, Event.class);
        Assert.assertEquals(id, event.getEvName());
        System.out.println(event.getEvName());
        restTempl.delete(url+ "/delete/" + id);

        event = restTempl.getForObject(url + "/read/"+id, Event.class);

        Assert.assertNotSame(id, event.getEvName());

        /*try
        {
        }
        catch (HttpClientErrorException hcee){
            Assert.assertEquals(hcee.getStatusCode(), HttpStatus.NOT_FOUND);
        }*/
    }

    @Test
    public void p_getAll()
    {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity respoEnt = restTempl.exchange(url + "/getAll", HttpMethod.GET, entity, String.class);
        Assert.assertNotSame(null, respoEnt.getBody());
    }
}