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
import za.ac.cput.Domain.Content.Services;
import za.ac.cput.Factory.ServicesFactory;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ServicesControllerTest {

    @Autowired
    private TestRestTemplate restTempl;
    private String url = "http://localhost:8080/services";

    @Test
    public void create()
    {
        Services services = ServicesFactory.chooseService("Food service",
                "Any services in a hotel delivered to a guest directly unto their rooms.", 1000.00);
        ResponseEntity<Services> response = restTempl.postForEntity(url + "/create", services, Services.class);
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getBody());
        System.out.println(response.getBody().getServName());
    }

    @Test
    public void read()
    {
        Services s  = restTempl.getForObject(url + "/read/true", Services.class);
        Assert.assertNotNull(s);
        System.out.println(s.getServName());
    }

    @Test
    public void update()
    {
        String id = "Food service";
        Services services  = restTempl.getForObject(url + "/read/" + id, Services.class);

        restTempl.put(url + "/update/" + id, services);
        Services update = restTempl.getForObject(url + "/read/" + id, Services.class);
        Assert.assertNotNull(update);
        System.out.println(update.getServName());

    }

    @Test
    public void delete()
    {
        String id = "Food service";
        Services services  = restTempl.getForObject(url + "/read/" + id, Services.class);
        Assert.assertEquals(id, services.getServName());
        System.out.println(services.getServName());
        restTempl.delete(url+ "/delete/" + id);

        services = restTempl.getForObject(url + "/read/"+id, Services.class);

        Assert.assertNotSame(id, services.getServName());

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