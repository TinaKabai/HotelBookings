package za.ac.cput.controller;


import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import za.ac.cput.Domain.Activites.Event;
import za.ac.cput.Domain.Content.Guest;
import za.ac.cput.Factory.GuestFactory;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class GuestControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/guest";

    @Test
    public void testGetAllGuests() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetGuestById() {
        Guest guest = restTemplate.getForObject(baseURL + "/guest/1", Guest.class);
        System.out.println(guest.getName());
        assertNotNull(guest);
    }

    @Ignore
    public void testCreateGuest() {
        Guest guest = GuestFactory.findGuest("Tina", "0731906340", "10 Dorset Street");

        ResponseEntity<Guest> postResponse = restTemplate.postForEntity(baseURL + "/create", guest, Guest.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateEventGuest() {
        int id = 1;
        Guest guest = restTemplate.getForObject(baseURL + "/guest/" + id, Guest.class);

        restTemplate.put(baseURL + "/events/" + id, guest);
        Guest updatedGuest = restTemplate.getForObject(baseURL + "/Guest/" + id, Guest.class);
        assertNotNull(updatedGuest);
    }

    @Ignore
    public void testDeleteGuest() {
        int id = 2;
        Guest guest = restTemplate.getForObject(baseURL + "/guests/" + id, Guest.class);
        assertNotNull(guest);
        restTemplate.delete(baseURL + "/guests/" + id);
        try {
            guest = restTemplate.getForObject(baseURL + "/guests/" + id, Guest.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}