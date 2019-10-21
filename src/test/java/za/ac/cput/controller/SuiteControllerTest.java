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
import za.ac.cput.Domain.Content.Suite;
import za.ac.cput.Factory.SuiteFactory;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class SuiteControllerTest {

    @Autowired
    private TestRestTemplate restTempl;
    private String url = "http://localhost:8080/suite rooms";

    @Test
    public void create()
    { Suite suite = SuiteFactory.suites(true);
        ResponseEntity<Suite> response = restTempl.postForEntity(url + "/create", suite, Suite.class);
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getBody());
        System.out.println(response.getBody().isSuite());
    }

    @Test
    public void read()
    {
        Suite s  = restTempl.getForObject(url + "/read/true", Suite.class);
        Assert.assertNotNull(s);
        System.out.println(s.isSuite());
    }

    @Test
    public void update()
    {
        boolean id = true;
        Suite suite  = restTempl.getForObject(url + "/read/" + id, Suite.class);

        restTempl.put(url + "/update/" + id, suite);
        Suite update = restTempl.getForObject(url + "/read/" + id, Suite.class);
        Assert.assertNotNull(update);
        System.out.println(update.isSuite());

    }

    @Test
    public void delete()
    {
        boolean id = true;
        Suite suite  = restTempl.getForObject(url + "/read/" + id, Suite.class);
        Assert.assertEquals(id, suite.isSuite());
        System.out.println(suite.isSuite());
        restTempl.delete(url+ "/delete/" + id);

        suite = restTempl.getForObject(url + "/read/"+id, Suite.class);

        Assert.assertNotSame(id, suite.isSuite());

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