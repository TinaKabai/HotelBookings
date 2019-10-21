package za.ac.cput.controller;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import za.ac.cput.Domain.Content.Restaurant;
import za.ac.cput.Factory.RestaurantFactory;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class RestaurantControllerTest {

    @Autowired
    private TestRestTemplate restTempl;
    private String url = "http://localhost:8080/restaurants";

    @Test
    public void create()
    {
        Restaurant restaurant = RestaurantFactory.findRestaurant("Riempies Restaurant", 8, "Main");
        ResponseEntity<Restaurant> response = restTempl.postForEntity(url + "/create", restaurant, Restaurant.class);
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getBody());
        System.out.println(response.getBody().getRestuName());
    }

    @Test
    public void read()
    {
        Restaurant r  = restTempl.getForObject(url + "/read/true", Restaurant.class);
        Assert.assertNotNull(r);
        System.out.println(r.getRestuName());
    }

    @Test
    public void update()
    {
        String id = "Riempies Restaurant";
        Restaurant restaurant  = restTempl.getForObject(url + "/read/" + id, Restaurant.class);

        restTempl.put(url + "/update/" + id, restaurant);
        Restaurant update = restTempl.getForObject(url + "/read/" + id, Restaurant.class);
        Assert.assertNotNull(update);
        System.out.println(update.getRestuName());

    }

    @Test
    public void delete()
    {
        String id = "Riempies Restaurant";
        Restaurant restaurant  = restTempl.getForObject(url + "/read/" + id, Restaurant.class);
        Assert.assertEquals(id, restaurant.getRestuName());
        System.out.println(restaurant.getRestuName());
        restTempl.delete(url+ "/delete/" + id);

        restaurant = restTempl.getForObject(url + "/read/"+id, Restaurant.class);

        Assert.assertNotSame(id, restaurant.getRestuName());

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