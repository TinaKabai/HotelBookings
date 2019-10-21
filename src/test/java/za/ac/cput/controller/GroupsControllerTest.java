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
import za.ac.cput.Domain.Tour.Groups;
import za.ac.cput.Factory.GroupsFactory;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)


public class GroupsControllerTest {

    @Autowired
    private TestRestTemplate restTempl;
    private String url = "http://localhost:8080/tour group";

    @Test
    public void create()
    {
        Groups groups = GroupsFactory.groups("Travelling", 5, 12);
        ResponseEntity<Groups> response = restTempl.postForEntity(url + "/create", groups, Groups.class);
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getBody());
        System.out.println(response.getBody().getGroupName());
    }

    @Test
    public void read()
    {
        Groups g  = restTempl.getForObject(url + "/read/true", Groups.class);
        Assert.assertNotNull(g);
        System.out.println(g.getGroupName());
    }

    @Test
    public void update()
    {
        String id = "Travelling";
        Groups groups  = restTempl.getForObject(url + "/read/" + id, Groups.class);

        restTempl.put(url + "/update/" + id, groups);
        Groups update = restTempl.getForObject(url + "/read/" + id, Groups.class);
        Assert.assertNotNull(update);
        System.out.println(update.getGroupName());

    }

    @Test
    public void delete()
    {
        String id = "Travelling";
        Groups groups  = restTempl.getForObject(url + "/read/" + id, Groups.class);
        Assert.assertEquals(id, groups.getGroupName());
        System.out.println(groups.getGroupName());
        restTempl.delete(url+ "/delete/" + id);

        groups = restTempl.getForObject(url + "/read/"+id, Groups.class);

        Assert.assertNotSame(id, groups.getGroupName());

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