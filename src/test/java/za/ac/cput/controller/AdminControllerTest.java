package za.ac.cput.controller;


import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import za.ac.cput.Domain.Users.Admin;
import za.ac.cput.Factory.AdminFactory;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class AdminControllerTest {

    @Autowired
    private TestRestTemplate restTempl;
    private String url = "http://localhost:8080/admin";

    @Test
    public void create()
    {
        Admin admin = AdminFactory.adminlogin("980303T", "Nkosi6991");
        ResponseEntity<Admin> response = restTempl.postForEntity(url + "/create", admin, Admin.class);
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getBody());
        System.out.println(response.getBody().getID() + " " + response.getBody().getPassword());
    }

    @Test
    public void read()
    {
        Admin a  = restTempl.getForObject(url + "/read/980303T", Admin.class);
        Assert.assertNotNull(a);
        System.out.println(a.getID() + " " + a.getPassword());
    }

    @Test
    public void update()
    {
        String id = "980303T";
        Admin admin  = restTempl.getForObject(url + "/read/" + id, Admin.class);

        restTempl.put(url + "/update/" + id, admin);
        Admin update = restTempl.getForObject(url + "/read/" + id, Admin.class);
        Assert.assertNotNull(update);
        System.out.println(update.getID() + " " + update.getPassword());

    }

    @Test
    public void delete()
    {
        String id = "980303T";
        Admin admin  = restTempl.getForObject(url + "/read/" + id, Admin.class);
        Assert.assertEquals(id, admin.getID());
        System.out.println(admin.getID() + admin.getPassword());
        restTempl.delete(url+ "/delete/" + id);

        admin = restTempl.getForObject(url + "/read/"+id, Admin.class);

        Assert.assertNotSame(id, admin.getID());

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