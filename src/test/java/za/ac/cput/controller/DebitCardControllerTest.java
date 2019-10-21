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
import za.ac.cput.Domain.Payment.DebitCard;
import za.ac.cput.Factory.DebitCardFactory;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class DebitCardControllerTest {

    @Autowired
    private TestRestTemplate restTempl;
    private String url = "http://localhost:8080/debit card";

    @Test
    public void create()
    {
        DebitCard debitCard = DebitCardFactory.dbtCard(600.00);
        ResponseEntity<DebitCard> response = restTempl.postForEntity(url + "/create", debitCard, DebitCard.class);
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getBody());
        System.out.println(response.getBody().getDeductions());
    }

    @Test
    public void read()
    {
        DebitCard dc  = restTempl.getForObject(url + "/read/500.00", DebitCard.class);
        Assert.assertNotNull(dc);
        System.out.println(dc.getDeductions());
    }

    @Test
    public void update()
    {
        double id = 600.00;
        DebitCard debitCard  = restTempl.getForObject(url + "/read/" + id, DebitCard.class);

        restTempl.put(url + "/update/" + id, debitCard);
        DebitCard update = restTempl.getForObject(url + "/read/" + id, DebitCard.class);
        Assert.assertNotNull(update);
        System.out.println(update.getDeductions());

    }

    @Test
    public void delete()
    {
        double id = 600.00;
        DebitCard debitCard  = restTempl.getForObject(url + "/read/" + id, DebitCard.class);
        Assert.assertEquals(id, debitCard.getDeductions());
        System.out.println(debitCard.getDeductions());
        restTempl.delete(url+ "/delete/" + id);

        debitCard = restTempl.getForObject(url + "/read/"+id, DebitCard.class);

        Assert.assertNotSame(id, debitCard.getDeductions());

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