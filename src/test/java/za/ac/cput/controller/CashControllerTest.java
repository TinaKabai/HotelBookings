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
import za.ac.cput.Domain.Payment.Cash;
import za.ac.cput.Factory.CashFactory;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class CashControllerTest {

    @Autowired
    private TestRestTemplate restTempl;
    private String url = "http://localhost:8080/cash";

    @Test
    public void create()
    {
        Cash cash = CashFactory.cash("10.00", 5.00);
        ResponseEntity<Cash> response = restTempl.postForEntity(url + "/create", cash, Cash.class);
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getBody());
        System.out.println(response.getBody().getAmount() + " " + response.getBody().getChange());
    }

    @Test
    public void read()
    {
        Cash c  = restTempl.getForObject(url + "/read/10.00", Cash.class);
        Assert.assertNotNull(c);
        System.out.println(c.getAmount() + " " + c.getChange());
    }

    @Test
    public void update()
    {
        String id = "0.00";
        Cash cash  = restTempl.getForObject(url + "/read/" + id, Cash.class);

        restTempl.put(url + "/update/" + id, cash);
        Cash update = restTempl.getForObject(url + "/read/" + id, Cash.class);
        Assert.assertNotNull(update);
        System.out.println(update.getAmount() + " " + update.getChange());

    }

    @Test
    public void delete()
    {
        String id = "10.00";
        Cash cash  = restTempl.getForObject(url + "/read/" + id, Cash.class);
        Assert.assertEquals(id, cash.getAmount());
        System.out.println(cash.getAmount() + cash.getChange());
        restTempl.delete(url+ "/delete/" + id);

        cash = restTempl.getForObject(url + "/read/"+id, Cash.class);

        Assert.assertNotSame(id, cash.getAmount());

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