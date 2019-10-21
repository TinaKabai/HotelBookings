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
import za.ac.cput.Domain.Payment.Card;
import za.ac.cput.Factory.CardFactory;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class CardControllerTest {

    @Autowired
    private TestRestTemplate restTempl;
    private String url = "http://localhost:8080/card";

    @Test
    public void create()
    {
        Card card = CardFactory.guestCard("6008158300567190", 6991);
        ResponseEntity<Card> response = restTempl.postForEntity(url + "/create", card, Card.class);
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getBody());
        System.out.println(response.getBody().getCardNo() + " " + response.getBody().getPin());
    }

    @Test
    public void read()
    {
        Card c  = restTempl.getForObject(url + "/read/6008158300567190", Card.class);
        Assert.assertNotNull(c);
        System.out.println(c.getCardNo() + " " + c.getPin());
    }

    @Test
    public void update()
    {
        String id = "6008158300567190";
        Card card  = restTempl.getForObject(url + "/read/" + id, Card.class);

        restTempl.put(url + "/update/" + id, card);
        Card update = restTempl.getForObject(url + "/read/" + id, Card.class);
        Assert.assertNotNull(update);
        System.out.println(update.getCardNo() + " " + update.getPin());

    }

    @Test
    public void delete()
    {
        String id = "6008158300567190";
        Card card  = restTempl.getForObject(url + "/read/" + id, Card.class);
        Assert.assertEquals(id, card.getCardNo());
        System.out.println(card.getCardNo() + card.getPin());
        restTempl.delete(url+ "/delete/" + id);

        card = restTempl.getForObject(url + "/read/"+id, Card.class);

        Assert.assertNotSame(id, card.getCardNo());

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