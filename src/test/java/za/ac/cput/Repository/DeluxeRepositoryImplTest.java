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
import za.ac.cput.Domain.Content.Deluxe;
import za.ac.cput.Factory.DeluxeFactory;
import za.ac.cput.Repository.content.DeluxeRepository;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class DeluxeRepositoryImplTest {

    @Autowired
    private DeluxeRepository classRepository;
    private List<Deluxe> classes;
    Deluxe dl;
    Deluxe d2;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void create() {
        dl = DeluxeFactory.delux(true);
        d2 = DeluxeFactory.delux(false);
        Deluxe d = this.classRepository.save(dl);
        Assert.assertEquals(dl.isDeluxe(), d.isDeluxe());
        Deluxe dd = this.classRepository.save(d2);
        Assert.assertEquals(d2.isDeluxe(), dd.isDeluxe());
    }

    @Test
    public void read()
    {
        String s = "true";
        Deluxe d1 = this.classRepository.findById(s).orElse(null);

        Assert.assertEquals(s, d1.isDeluxe());
        System.out.println(d1.isDeluxe());
    }

    @Test
    public void update()
    {
        dl = DeluxeFactory.delux(true);
        Deluxe d = this.classRepository.save(dl);
        Assert.assertEquals(dl.isDeluxe(), d.isDeluxe());
        System.out.println(d.isDeluxe());
    }

    @Test
    public void delete()
    {
        String s = "true";
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