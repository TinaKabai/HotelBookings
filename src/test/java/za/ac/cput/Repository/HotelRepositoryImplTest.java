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
import za.ac.cput.Domain.Content.Hotel;
import za.ac.cput.Factory.HotelFactory;
import za.ac.cput.Repository.content.HotelRepository;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class HotelRepositoryImplTest {

    @Autowired
    private HotelRepository classRepository;
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
        h2 = HotelFactory.chooseHotel("Cape Town", 8000, "The Peninsula All-Suite Hotel", "313 Beach Rd",
                "021 430 7777", "https://http://peninsula.co.za/");
        Hotel h = this.classRepository.save(hl);
        Assert.assertEquals(hl.getHotelName(), h.getHotelName());
        Hotel hh = this.classRepository.save(h2);
        Assert.assertEquals(h2.getHotelName(), hh.getHotelName());
    }

    @Test
    public void read() {
        String s = "Cape Sun Hotel";
        Hotel h1 = this.classRepository.findById(s).orElse(null);

        Assert.assertEquals(s, h1.getHotelName());
        System.out.println(h1.getHotelName() + " " + h1.getPhone());
    }

    @Test
    public void update()
    {
        hl = HotelFactory.chooseHotel("Cape Town", 8000, "Cape Sun Hotel", "23 Strand St",
                "021 488 5100", "https://southern-sun-cape-sun.capetown-hotels-za.com/en/");
        Hotel h = this.classRepository.save(hl);
        Assert.assertEquals(hl.getHotelName(), h.getHotelName());
        System.out.println(h.getHotelName() + "\n" + h.getPhone());
    }

    @Test
    public void delete()
    {
        String s = "Cape Sun Hotel";
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