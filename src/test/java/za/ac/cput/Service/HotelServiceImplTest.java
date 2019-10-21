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
import za.ac.cput.Domain.Content.Hotel;
import za.ac.cput.Factory.HotelFactory;
import za.ac.cput.Service.Content.implementations.HotelServiceImpl;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class HotelServiceImplTest {

    @Autowired
    private HotelServiceImpl service;
    private List<Hotel> classes;
    Hotel hl;
    Hotel h2;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void create() {
        hl = HotelFactory.chooseHotel("Cape Town", 8000, "Cape Sun Hotel", "23 Strand St",
                "021 488 5100", "https://southern-sun-cape-sun.capetown-hotels-za.com/en/");
        Hotel h = this.service.create(hl);
        Assert.assertEquals(hl.getHotelName(), h.getHotelName());
    }

    @Test
    public void read() {
        String s = "Cape Sun Hotel";
        Hotel hl = this.service.read(s);

        Assert.assertEquals(s, hl.getHotelName());
        System.out.println(hl.getHotelName() + " " + hl.getPhone());
    }

    @Test
    public void update() {
        hl = HotelFactory.chooseHotel("Cape Town", 8000, "Cape Sun Hotel", "23 Strand St",
                "021 488 5100", "https://southern-sun-cape-sun.capetown-hotels-za.com/en/");
        Hotel h = this.service.update(hl);
        Assert.assertEquals(hl.getHotelName(), h.getHotelName());
        System.out.println(h.getHotelName() + "\n" + h.getPhone());
    }

    @Test
    public void delete() {
        String s = "Cape Sun Hotel";
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