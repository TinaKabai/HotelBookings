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
import za.ac.cput.Domain.Tour.Attendance;
import za.ac.cput.Factory.AttendanceFactory;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class AttendanceControllerTest {

    @Autowired
    private TestRestTemplate restTempl;
    private String url = "http://localhost:8080/attendance";

    @Test
    public void create()
    {
        Attendance attendance = AttendanceFactory.attendingGuests(true);
        ResponseEntity<Attendance> response = restTempl.postForEntity(url + "/create", attendance, Attendance.class);
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getBody());
        System.out.println(response.getBody().isAttending());
    }

    @Test
    public void read()
    {
        Attendance a  = restTempl.getForObject(url + "/read/true", Attendance.class);
        Assert.assertNotNull(a);
        System.out.println(a.isAttending());
    }

    @Test
    public void update()
    {
        boolean id = true;
        Attendance attendance  = restTempl.getForObject(url + "/read/" + id, Attendance.class);

        restTempl.put(url + "/update/" + id, attendance);
        Attendance update = restTempl.getForObject(url + "/read/" + id, Attendance.class);
        Assert.assertNotNull(update);
        System.out.println(update.isAttending());

    }

    @Test
    public void delete()
    {
        boolean id = true;
        Attendance attendance  = restTempl.getForObject(url + "/read/" + id, Attendance.class);
        Assert.assertEquals(id, attendance.isAttending());
        System.out.println(attendance.getName());
        restTempl.delete(url+ "/delete/" + id);

        attendance = restTempl.getForObject(url + "/read/"+id, Attendance.class);

        Assert.assertNotSame(id, attendance.isAttending());

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