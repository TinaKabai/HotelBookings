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
import za.ac.cput.Domain.Payment.CreditCard;
import za.ac.cput.Factory.CreditCardFactory;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class CreditCardControllerTest {

    @Autowired
    private TestRestTemplate restTempl;
    private String url = "http://localhost:8080/credit card";

    @Test
    public void create()
    {
        CreditCard creditCard = CreditCardFactory.cdtCard(1000.00);
        ResponseEntity<CreditCard> response = restTempl.postForEntity(url + "/create", creditCard, CreditCard.class);
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getBody());
        System.out.println(response.getBody().getCredits());
    }

    @Test
    public void read()
    {
        CreditCard cc  = restTempl.getForObject(url + "/read/1000.00", CreditCard.class);
        Assert.assertNotNull(cc);
        System.out.println(cc.getCredits());
    }

    @Test
    public void update()
    {
        double id = 1000.00;
        CreditCard creditCard  = restTempl.getForObject(url + "/read/" + id, CreditCard.class);

        restTempl.put(url + "/update/" + id, creditCard);
        CreditCard update = restTempl.getForObject(url + "/read/" + id, CreditCard.class);
        Assert.assertNotNull(update);
        System.out.println(update.getCredits());

    }

    @Test
    public void delete()
    {
        double id = 1000.00;
        CreditCard creditCard  = restTempl.getForObject(url + "/read/" + id, CreditCard.class);
        Assert.assertEquals(id, creditCard.getCredits());
        System.out.println(creditCard.getCredits());
        restTempl.delete(url+ "/delete/" + id);

        creditCard = restTempl.getForObject(url + "/read/"+id, CreditCard.class);

        Assert.assertNotSame(id, creditCard.getCredits());

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