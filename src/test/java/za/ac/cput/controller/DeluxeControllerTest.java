package za.ac.cput.controller;


import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import za.ac.cput.Domain.Content.Deluxe;
import za.ac.cput.Factory.DeluxeFactory;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class DeluxeControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/deluxe";

    @Test
    public void testGetAllDeluxe() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetDeluxeById() {
        Deluxe deluxe = restTemplate.getForObject(baseURL + "/booking/1", Deluxe.class);
        System.out.println(deluxe.getRoomType());
        assertNotNull(deluxe);
    }

    @Ignore
    public void testCreateDeluxe() {
        Deluxe deluxe = DeluxeFactory.delux(true);

        ResponseEntity<Deluxe> postResponse = restTemplate.postForEntity(baseURL + "/create", deluxe, Deluxe.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateDeluxe() {
        int id = 1;
        Deluxe deluxe = restTemplate.getForObject(baseURL + "/deluxe/" + id, Deluxe.class);

        restTemplate.put(baseURL + "/deluxe/" + id, deluxe);
        Deluxe updatedDeluxe = restTemplate.getForObject(baseURL + "/Deluxe/" + id, Deluxe.class);
        assertNotNull(updatedDeluxe);
    }

    @Ignore
    public void testDeletDeluxe() {
        int id = 2;
        Deluxe deluxe = restTemplate.getForObject(baseURL + "/deluxe/" + id, Deluxe.class);
        assertNotNull(deluxe);
        restTemplate.delete(baseURL + "/deluxe/" + id);
        try {
            deluxe = restTemplate.getForObject(baseURL + "/deluxe/" + id, Deluxe.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}