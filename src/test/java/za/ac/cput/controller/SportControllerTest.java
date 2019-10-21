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
import za.ac.cput.Domain.Activites.Sport;
import za.ac.cput.Factory.SportFactory;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class SportControllerTest {

    @Autowired
    private TestRestTemplate restTempl;
    private String url = "http://localhost:8080/sports";

    @Test
    public void create()
    { Sport sport = SportFactory.findSport("Rugby", "Tina", 30, "Cape Sun Hotel");
        ResponseEntity<Sport> response = restTempl.postForEntity(url + "/create", sport, Sport.class);
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getBody());
        System.out.println(response.getBody().getSportName() + " " +response.getBody().getNoParticipants());
    }

    @Test
    public void read()
    {
        Sport s  = restTempl.getForObject(url + "/read/true", Sport.class);
        Assert.assertNotNull(s);
        System.out.println(s.getSportName() + " " + s.getNoParticipants());
    }

    @Test
    public void update()
    {
        String id = "Rugby";
        Sport sport  = restTempl.getForObject(url + "/read/" + id, Sport.class);

        restTempl.put(url + "/update/" + id, sport);
        Sport update = restTempl.getForObject(url + "/read/" + id, Sport.class);
        Assert.assertNotNull(update);
        System.out.println(update.getSportName() + " " + update.getNoParticipants());

    }

    @Test
    public void delete()
    {
        String id = "Rugby";
        Sport sport  = restTempl.getForObject(url + "/read/" + id, Sport.class);
        Assert.assertEquals(id, sport.getSportName());
        System.out.println(sport.getSportName() + " " + sport.getNoParticipants());
        restTempl.delete(url+ "/delete/" + id);

        sport = restTempl.getForObject(url + "/read/"+id, Sport.class);

        Assert.assertNotSame(id, sport.getNoParticipants());

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