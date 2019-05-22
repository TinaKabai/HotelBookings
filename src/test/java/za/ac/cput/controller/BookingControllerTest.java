package za.ac.cput.controller;


import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import za.ac.cput.Domain.Content.Booking;
import za.ac.cput.Factory.BookingFactory;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class BookingControllerTest {

    @Autowired
    @Qualifier("BookingServiceImpl")
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/booking";

    @Test
    public void testGetAllBookings() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetBookingById() {
        Booking booking = restTemplate.getForObject(baseURL + "/booking/1", Booking.class);
        System.out.println(booking.getName());
        assertNotNull(booking);
    }

    @Ignore
    public void testCreateBooking() {
        Booking booking = BookingFactory.bookings(true);

        ResponseEntity<Booking> postResponse = restTemplate.postForEntity(baseURL + "/create", booking, Booking.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateBooking() {
        int id = 1;
        Booking booking = restTemplate.getForObject(baseURL + "/booking/" + id, Booking.class);

        restTemplate.put(baseURL + "/booking/" + id, booking);
        Booking updatedBooking = restTemplate.getForObject(baseURL + "/Booking/" + id, Booking.class);
        assertNotNull(updatedBooking);
    }

    @Ignore
    public void testDeletBooking() {
        int id = 2;
        Booking booking = restTemplate.getForObject(baseURL + "/bookings/" + id, Booking.class);
        assertNotNull(booking);
        restTemplate.delete(baseURL + "/booking/" + id);
        try {
            booking = restTemplate.getForObject(baseURL + "/booking/" + id, Booking.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}