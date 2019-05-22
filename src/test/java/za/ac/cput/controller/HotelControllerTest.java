package za.ac.cput.controller;


import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import za.ac.cput.Domain.Content.Hotel;
import za.ac.cput.Factory.HotelFactory;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class HotelControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/hotel";

    @Test
    public void testGetAllHotels() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetHotelById() {
        Hotel hotel = restTemplate.getForObject(baseURL + "/hotel/1", Hotel.class);
        System.out.println(hotel.getHotelName());
        assertNotNull(hotel);
    }

    @Ignore
    public void testCreateHotel() {
        Hotel hotel = HotelFactory.chooseHotel("Cape Town ", 8000, "Cape Sun Hotel", "23 Strand St",
                "021 488 5100", "https://southern-sun-cape-sun.capetown-hotels-za.com/en/");

        ResponseEntity<Hotel> postResponse = restTemplate.postForEntity(baseURL + "/create", hotel, Hotel.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateHotel() {
        int id = 1;
        Hotel hotel = restTemplate.getForObject(baseURL + "/hotel/" + id, Hotel.class);

        restTemplate.put(baseURL + "/hotel/" + id, hotel);
        Hotel updatedHotel = restTemplate.getForObject(baseURL + "/Hotel/" + id, Hotel.class);
        assertNotNull(updatedHotel);
    }

    @Ignore
    public void testDeleteHotel() {
        int id = 2;
        Hotel hotel = restTemplate.getForObject(baseURL + "/hotel/" + id, Hotel.class);
        assertNotNull(hotel);
        restTemplate.delete(baseURL + "/hotels/" + id);
        try {
            hotel = restTemplate.getForObject(baseURL + "/hotels/" + id, Hotel.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}