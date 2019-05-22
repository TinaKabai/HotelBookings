package za.ac.cput.controller;


import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import za.ac.cput.Domain.Activites.Sport;
import za.ac.cput.Factory.SportFactory;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class SportControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/sport";

    @Test
    public void testGetAllSports() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetSportById() {
        Sport sport = restTemplate.getForObject(baseURL + "/sport/1", Sport.class);
        System.out.println(sport.getSportName());
        assertNotNull(sport);
    }

    @Ignore
    public void testCreateSport() {
        Sport sport = SportFactory.findSport("Rugby",
                "Tina", 30, "Cape Sun Hotel");

        ResponseEntity<Sport> postResponse = restTemplate.postForEntity(baseURL + "/create", sport, Sport.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateSport() {
        int id = 1;
        Sport sport = restTemplate.getForObject(baseURL + "/sport/" + id, Sport.class);

        restTemplate.put(baseURL + "/sport/" + id, sport);
        Sport updatedSport = restTemplate.getForObject(baseURL + "/Sport/" + id, Sport.class);
        assertNotNull(updatedSport);
    }

    @Ignore
    public void testDeletSport() {
        int id = 2;
        Sport sport = restTemplate.getForObject(baseURL + "/sports/" + id, Sport.class);
        assertNotNull(sport);
        restTemplate.delete(baseURL + "/sports/" + id);
        try {
            sport = restTemplate.getForObject(baseURL + "/sports/" + id, Sport.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}