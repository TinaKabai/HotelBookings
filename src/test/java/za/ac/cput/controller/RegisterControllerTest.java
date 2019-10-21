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
import za.ac.cput.Domain.Users.Register;
import za.ac.cput.Factory.RegisterFactory;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class RegisterControllerTest {

    @Autowired
    private TestRestTemplate restTempl;
    private String url = "http://localhost:8080/registration";

    @Test
    public void create()
    {
        Register register = RegisterFactory.registration("Thato", "Kabai", "17 Feb 2002",
                "TKL", "TK2002", "TK2002");
        ResponseEntity<Register> response = restTempl.postForEntity(url + "/create", register, Register.class);
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getBody());
        System.out.println(response.getBody().getUsername() + " " + response.getBody().getPassword());
    }

    @Test
    public void read()
    {
        Register r  = restTempl.getForObject(url + "/read/true", Register.class);
        Assert.assertNotNull(r);
        System.out.println(r.getUsername() + " " + r.getPassword());
    }

    @Test
    public void update()
    {
        String id = "TKL";
        Register register  = restTempl.getForObject(url + "/read/" + id, Register.class);

        restTempl.put(url + "/update/" + id, register);
        Register update = restTempl.getForObject(url + "/read/" + id, Register.class);
        Assert.assertNotNull(update);
        System.out.println(update.getUsername() + " " + update.getPassword());

    }

    @Test
    public void delete()
    {
        String id = "TKL";
        Register register  = restTempl.getForObject(url + "/read/" + id, Register.class);
        Assert.assertEquals(id, register.getUsername());
        System.out.println(register.getUsername() + register.getPassword());
        restTempl.delete(url+ "/delete/" + id);

        register = restTempl.getForObject(url + "/read/"+id, Register.class);

        Assert.assertNotSame(id, register.getUsername());

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