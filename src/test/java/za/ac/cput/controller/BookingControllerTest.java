package za.ac.cput.controller;


import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import za.ac.cput.Domain.Content.Booking;
import za.ac.cput.Factory.BookingFactory;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class BookingControllerTest {

    @Autowired
    private TestRestTemplate restTempl;
    private String url = "http://localhost:8080/booking";

    @Test
    public void create()
    {
        Booking booking = BookingFactory.bookings(true);
        ResponseEntity<Booking> response = restTempl.postForEntity(url + "/create", booking, Booking.class);
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getBody());
        System.out.println(response.getBody().isPay());
    }

    @Test
    public void read()
    {
        Booking b  = restTempl.getForObject(url + "/read/true", Booking.class);
        Assert.assertNotNull(b);
        System.out.println(b.isPay());
    }

    @Test
    public void update()
    {
        boolean id = true;
        Booking booking  = restTempl.getForObject(url + "/read/" + id, Booking.class);

        restTempl.put(url + "/update/" + id, booking);
        Booking update = restTempl.getForObject(url + "/read/" + id, Booking.class);
        Assert.assertNotNull(update);
        System.out.println(update.isPay());

    }

    @Test
    public void delete()
    {
        boolean id = true;
        Booking booking  = restTempl.getForObject(url + "/read/" + id, Booking.class);
        Assert.assertEquals(id, booking.isPay());
        System.out.println(booking.getName());
        restTempl.delete(url+ "/delete/" + id);

        booking = restTempl.getForObject(url + "/read/"+id, Booking.class);

        Assert.assertNotSame(id, booking.isPay());

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