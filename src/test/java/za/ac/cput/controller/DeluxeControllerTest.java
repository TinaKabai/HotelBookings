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
import za.ac.cput.Domain.Content.Deluxe;
import za.ac.cput.Factory.DeluxeFactory;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class DeluxeControllerTest {

    @Autowired
    private TestRestTemplate restTempl;
    private String url = "http://localhost:8080/deluxe rooms";

    @Test
    public void create()
    {
        Deluxe deluxe = DeluxeFactory.delux(true);
        ResponseEntity<Deluxe> response = restTempl.postForEntity(url + "/create", deluxe, Deluxe.class);
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getBody());
        System.out.println(response.getBody().isDeluxe());
    }

    @Test
    public void read()
    {
        Deluxe d  = restTempl.getForObject(url + "/read/true", Deluxe.class);
        Assert.assertNotNull(d);
        System.out.println(d.isDeluxe());
    }

    @Test
    public void update()
    {
        boolean id = true;
        Deluxe deluxe  = restTempl.getForObject(url + "/read/" + id, Deluxe.class);

        restTempl.put(url + "/update/" + id, deluxe);
        Deluxe update = restTempl.getForObject(url + "/read/" + id, Deluxe.class);
        Assert.assertNotNull(update);
        System.out.println(update.isDeluxe());

    }

    @Test
    public void delete()
    {
        boolean id = true;
        Deluxe deluxe  = restTempl.getForObject(url + "/read/" + id, Deluxe.class);
        Assert.assertEquals(id, deluxe.isDeluxe());
        System.out.println(deluxe.isDeluxe());
        restTempl.delete(url+ "/delete/" + id);

        deluxe = restTempl.getForObject(url + "/read/"+id, Deluxe.class);

        Assert.assertNotSame(id, deluxe.isDeluxe());

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