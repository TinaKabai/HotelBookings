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
import za.ac.cput.Domain.Content.Hotel;
import za.ac.cput.Factory.HotelFactory;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class HotelControllerTest {

    @Autowired
    private TestRestTemplate restTempl;
    private String url = "http://localhost:8080/hotel";

    @Test
    public void create()
    {
        Hotel hotel = HotelFactory.chooseHotel("Cape Town", 8000, "Cape Sun Hotel", "23 Strand St",
                "021 488 5100", "https://southern-sun-cape-sun.capetown-hotels-za.com/en/");
        ResponseEntity<Hotel> response = restTempl.postForEntity(url + "/create", hotel, Hotel.class);
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getBody());
        System.out.println(response.getBody().getHotelName());
    }

    @Test
    public void read()
    {
        Hotel h  = restTempl.getForObject(url + "/read/true", Hotel.class);
        Assert.assertNotNull(h);
        System.out.println(h.getHotelName());
    }

    @Test
    public void update()
    {
        String id = "Cape Sun Hotel";
        Hotel hotel  = restTempl.getForObject(url + "/read/" + id, Hotel.class);

        restTempl.put(url + "/update/" + id, hotel);
        Hotel update = restTempl.getForObject(url + "/read/" + id, Hotel.class);
        Assert.assertNotNull(update);
        System.out.println(update.getHotelName());

    }

    @Test
    public void delete()
    {
        String id = "Cape Sun Hotel";
        Hotel hotel  = restTempl.getForObject(url + "/read/" + id, Hotel.class);
        Assert.assertEquals(id, hotel.getHotelName());
        System.out.println(hotel.getHotelName());
        restTempl.delete(url+ "/delete/" + id);

        hotel = restTempl.getForObject(url + "/read/"+id, Hotel.class);

        Assert.assertNotSame(id, hotel.getHotelName());

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