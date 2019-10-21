package za.ac.cput.Service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import za.ac.cput.Domain.Content.Restaurant;
import za.ac.cput.Factory.RestaurantFactory;
import za.ac.cput.Service.Content.implementations.RestaurantServiceImpl;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class RestaurantServiceImplTest {

    @Autowired
    private RestaurantServiceImpl service;
    private List<Restaurant> classes;
    Restaurant rl;
    Restaurant r2;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void create() {
        rl = RestaurantFactory.findRestaurant("Riempies Restaurant", 8, "Main");
        Restaurant r = this.service.create(rl);
        Assert.assertEquals(rl.getRestuName(), r.getRestuName());
    }

    @Test
    public void read() {
        String s = "Riempies Restaurant";
        Restaurant rl = this.service.read(s);

        Assert.assertEquals(s, rl.getRestuName());
        System.out.println(rl.getRestuName() + " " + rl.getRestuName());
    }

    @Test
    public void update() {
        rl = RestaurantFactory.findRestaurant("Riempies Restaurant", 8, "Main");
        Restaurant r = this.service.update(rl);
        Assert.assertEquals(rl.getRestuName(), r.getRestuName());
        System.out.println(r.getRestuName() + "\n" + r.getFloor());
    }

    @Test
    public void delete() {
        String s = "Riempies Restaurant";
        this.service.delete(s);
        classes = this.service.getAll();
        int size = classes.size();
        System.out.println(size);
        Assert.assertEquals(classes.size(), size);
    }

    @Test
    public void getAll() {
        classes = this.service.getAll();
        System.out.println(classes.size());
        Assert.assertEquals(1, classes.size());
    }
}