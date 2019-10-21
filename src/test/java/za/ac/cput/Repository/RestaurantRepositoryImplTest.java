package za.ac.cput.Repository;

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
import za.ac.cput.Repository.content.RestaurantRepository;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class RestaurantRepositoryImplTest {

    @Autowired
    private RestaurantRepository classRepository;
    private List<Restaurant> classes;
    Restaurant rl;
    Restaurant r2;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void create() {
        rl = RestaurantFactory.findRestaurant("Riempies Restaurant", 8, "Main");
        r2 = RestaurantFactory.findRestaurant("Strolla Restaurant", 1, "Starters");
        Restaurant r = this.classRepository.save(rl);
        Assert.assertEquals(rl.getRestuName(), r.getRestuName());
        Restaurant rr = this.classRepository.save(r2);
        Assert.assertEquals(r2.getRestuName(), rr.getRestuName());
    }

    @Test
    public void read() {
        String s = "Riempies Restaurant";
        Restaurant r1 = this.classRepository.findById(s).orElse(null);

        Assert.assertEquals(s, r1.getRestuName());
        System.out.println(r1.getRestuName() + " " + r1.getFloor());
    }

    @Test
    public void update()
    {
        rl = RestaurantFactory.findRestaurant("Riempies Restaurant", 8, "Main");
        Restaurant r = this.classRepository.save(rl);
        Assert.assertEquals(rl.getRestuName(), r.getRestuName());
        System.out.println(r.getRestuName() + "\n" + r.getFloor());
    }

    @Test
    public void delete()
    {
        String s = "Riempies Restaurant";
        this.classRepository.deleteById(s);
        classes = this.classRepository.findAll();
        int size = classes.size();
        Assert.assertEquals(1, size);
    }

    @Test
    public void p_getAll()
    {
        classes = this.classRepository.findAll();
        Assert.assertEquals(1, classes.size());

        System.out.println(classes.size());
    }
}