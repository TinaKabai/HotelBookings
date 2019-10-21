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
import za.ac.cput.Domain.Payment.Receipt;
import za.ac.cput.Factory.ReceiptFactory;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ReceiptControllerTest {

    @Autowired
    private TestRestTemplate restTempl;
    private String url = "http://localhost:8080/payment receipts";

    @Test
    public void create()
    {
        Receipt receipt = ReceiptFactory.receipt("10 May 2019", "78557888",
                "78855", "79559456", "7410");
        ResponseEntity<Receipt> response = restTempl.postForEntity(url + "/create", receipt, Receipt.class);
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getBody());
        System.out.println(response.getBody().getPaymentRef() + " " + response.getBody().getItemDescription());
    }

    @Test
    public void read()
    {
        Receipt r  = restTempl.getForObject(url + "/read/true", Receipt.class);
        Assert.assertNotNull(r);
        System.out.println(r.getPaymentRef() + " " + r.getItemDescription());
    }

    @Test
    public void update()
    {
        String id = "79559456";
        Receipt receipt  = restTempl.getForObject(url + "/read/" + id, Receipt.class);

        restTempl.put(url + "/update/" + id, receipt);
        Receipt update = restTempl.getForObject(url + "/read/" + id, Receipt.class);
        Assert.assertNotNull(update);
        System.out.println(update.getPaymentRef() + " " + update.getItemDescription());

    }

    @Test
    public void delete()
    {
        String id = "79559456";
        Receipt receipt  = restTempl.getForObject(url + "/read/" + id, Receipt.class);
        Assert.assertEquals(id, receipt.getItemDescription());
        System.out.println(receipt.getPaymentRef() + receipt.getItemDescription());
        restTempl.delete(url+ "/delete/" + id);

        receipt = restTempl.getForObject(url + "/read/"+id, Receipt.class);

        Assert.assertNotSame(id, receipt.getPaymentRef());

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