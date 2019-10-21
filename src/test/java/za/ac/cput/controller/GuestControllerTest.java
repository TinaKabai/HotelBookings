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
import org.springframework.web.client.HttpClientErrorException;
import za.ac.cput.Domain.Activites.Event;
import za.ac.cput.Domain.Content.Guest;
import za.ac.cput.Factory.GuestFactory;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class GuestControllerTest {

    @Autowired
    private TestRestTemplate restTempl;
    private String url = "http://localhost:8080/guest";

    @Test
    public void create()
    {
        Guest guest = GuestFactory.findGuest("Tina", "0731906340", "10 Dorset Street");
        ResponseEntity<Guest> response = restTempl.postForEntity(url + "/create", guest, Guest.class);
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getBody());
        System.out.println(response.getBody().getName());
    }

    @Test
    public void read()
    {
        Guest g  = restTempl.getForObject(url + "/read/true", Guest.class);
        Assert.assertNotNull(g);
        System.out.println(g.getName());
    }

    @Test
    public void update()
    {
        String id = "Tina";
        Guest guest  = restTempl.getForObject(url + "/read/" + id, Guest.class);

        restTempl.put(url + "/update/" + id, guest);
        Guest update = restTempl.getForObject(url + "/read/" + id, Guest.class);
        Assert.assertNotNull(update);
        System.out.println(update.getName());

    }

    @Test
    public void delete()
    {
        String id = "Tina";
        Guest guest  = restTempl.getForObject(url + "/read/" + id, Guest.class);
        Assert.assertEquals(id, guest.getName());
        System.out.println(guest.getName());
        restTempl.delete(url+ "/delete/" + id);

        guest = restTempl.getForObject(url + "/read/"+id, Guest.class);

        Assert.assertNotSame(id, guest.getName());

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