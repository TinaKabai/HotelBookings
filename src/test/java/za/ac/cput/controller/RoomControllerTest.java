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
import za.ac.cput.Domain.Content.Room;
import za.ac.cput.Factory.RoomFactory;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class RoomControllerTest {

    @Autowired
    private TestRestTemplate restTempl;
    private String url = "http://localhost:8080/rooms";

    @Test
    public void create()
    {
        Room room = RoomFactory.findRoom(525, " double", "available", 3, 900.00);
        ResponseEntity<Room> response = restTempl.postForEntity(url + "/create", room, Room.class);
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getBody());
        System.out.println(response.getBody().getRoomNo() + " " + response.getBody().getRoomStatus());
    }

    @Test
    public void read()
    {
        Room r  = restTempl.getForObject(url + "/read/true", Room.class);
        Assert.assertNotNull(r);
        System.out.println(r.getRoomNo() + " " + r.getRoomStatus());
    }

    @Test
    public void update()
    {
        int id = 525;
        Room room  = restTempl.getForObject(url + "/read/" + id, Room.class);

        restTempl.put(url + "/update/" + id, room);
        Room update = restTempl.getForObject(url + "/read/" + id, Room.class);
        Assert.assertNotNull(update);
        System.out.println(update.getRoomNo() + " " + update.getRoomStatus());

    }

    @Test
    public void delete()
    {
        int id = 525;
        Room room  = restTempl.getForObject(url + "/read/" + id, Room.class);
        Assert.assertEquals(id, room.getRoomNo());
        System.out.println(room.getRoomNo() + room.getRoomStatus());
        restTempl.delete(url+ "/delete/" + id);

        room = restTempl.getForObject(url + "/read/"+id, Room.class);

        Assert.assertNotSame(id, room.getRoomNo());

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