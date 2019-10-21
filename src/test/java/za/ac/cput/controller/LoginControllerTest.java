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
import za.ac.cput.Domain.Users.Login;
import za.ac.cput.Factory.LoginFactory;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class LoginControllerTest {

    @Autowired
    private TestRestTemplate restTempl;
    private String url = "http://localhost:8080/login";

    @Test
    public void create()
    {
        Login login = LoginFactory.login("TinaN", "980303T");
        ResponseEntity<Login> response = restTempl.postForEntity(url + "/create", login, Login.class);
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getBody());
        System.out.println(response.getBody().getUsername() + " " + response.getBody().getPassword());
    }

    @Test
    public void read()
    {
        Login l  = restTempl.getForObject(url + "/read/true", Login.class);
        Assert.assertNotNull(l);
        System.out.println(l.getUsername() + " " +l.getPassword());
    }

    @Test
    public void update()
    {
        String id = "TinaN";
        Login login  = restTempl.getForObject(url + "/read/" + id, Login.class);

        restTempl.put(url + "/update/" + id, login);
        Login update = restTempl.getForObject(url + "/read/" + id, Login.class);
        Assert.assertNotNull(update);
        System.out.println(update.getUsername() + " " + update.getPassword());

    }

    @Test
    public void delete()
    {
        String id = "TinaN";
        Login login  = restTempl.getForObject(url + "/read/" + id, Login.class);
        Assert.assertEquals(id, login.getUsername());
        System.out.println(login.getUsername() + login.getPassword());
        restTempl.delete(url+ "/delete/" + id);

        login = restTempl.getForObject(url + "/read/"+id, Login.class);

        Assert.assertNotSame(id, login.getUsername());

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