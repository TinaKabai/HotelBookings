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
import za.ac.cput.Domain.Content.NonAC;
import za.ac.cput.Factory.NonACFactory;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class NonACControllerTest {

    @Autowired
    private TestRestTemplate restTempl;
    private String url = "http://localhost:8080/non AC rooms";

    @Test
    public void create()
    {
        NonAC nonAC = NonACFactory.accessibility(true);
        ResponseEntity<NonAC> response = restTempl.postForEntity(url + "/create", nonAC, NonAC.class);
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getBody());
        System.out.println(response.getBody().isNonAC());
    }

    @Test
    public void read()
    {
        NonAC n  = restTempl.getForObject(url + "/read/true", NonAC.class);
        Assert.assertNotNull(n);
        System.out.println(n.isNonAC());
    }

    @Test
    public void update()
    {
        boolean id = true;
        NonAC nonAC  = restTempl.getForObject(url + "/read/" + id, NonAC.class);

        restTempl.put(url + "/update/" + id, nonAC);
        NonAC update = restTempl.getForObject(url + "/read/" + id, NonAC.class);
        Assert.assertNotNull(update);
        System.out.println(update.isNonAC());

    }

    @Test
    public void delete()
    {
        boolean id = true;
        NonAC nonAC  = restTempl.getForObject(url + "/read/" + id, NonAC.class);
        Assert.assertEquals(id, nonAC.isNonAC());
        System.out.println(nonAC.isNonAC());
        restTempl.delete(url+ "/delete/" + id);

        nonAC = restTempl.getForObject(url + "/read/"+id, NonAC.class);

        Assert.assertNotSame(id, nonAC.isNonAC());

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