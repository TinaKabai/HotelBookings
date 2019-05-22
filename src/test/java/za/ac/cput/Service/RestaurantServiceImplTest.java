package za.ac.cput.Service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import za.ac.cput.Domain.Content.Restaurant;
import za.ac.cput.Factory.RestaurantFactory;
import za.ac.cput.Repository.Implementation.RestaurantRepositoryImpl;
import za.ac.cput.Repository.RestaurantRepository;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class RestaurantServiceImplTest {

    private RestaurantRepository repository;

    private Restaurant restaurant;

    @Before
    public void setUp() throws Exception {

        this.repository = (RestaurantRepositoryImpl) RestaurantRepositoryImpl.getRepository();

        this.restaurant = RestaurantFactory.findRestaurant("Riempies Restaurant", 8, "Main");
    }

    @Test
    public void d_getAll() {
        Set<Restaurant> restaurant = this.repository.getAll();

        System.out.println("In getAll, all = " + restaurant);
    }

    @Test
    public void create() {

        Restaurant created = this.repository.create(this.restaurant);

        System.out.println("In create, created = " + created);

        Assert.assertNotNull(created);

        Assert.assertSame(created, this.restaurant);
    }

    @Test
    public void read() {

        Restaurant read = this.repository.read(restaurant.getRestuName());

        System.out.println("In read, read = " + read);

        d_getAll();
        Assert.assertEquals(read, restaurant);
    }

    @Test
    public void update() {

        String newRest = "Obz Cafe";

        Restaurant updated = new Restaurant.Builder().restuname(newRest).build();

        System.out.println("In update, about_to_updated = " + updated);

        this.repository.update(updated);

        Assert.assertEquals(newRest, updated.getRestuName());
        d_getAll();
    }

    @Test
    public void delete() {

        this.repository.delete(restaurant.getRestuName());
        d_getAll();
    }
}