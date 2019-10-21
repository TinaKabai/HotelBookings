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
import za.ac.cput.Domain.Content.Services;
import za.ac.cput.Factory.ServicesFactory;
import za.ac.cput.Repository.content.ServicesRepository;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ServicesRepositoryImplTest {

    @Autowired
    private ServicesRepository classRepository;
    private List<Services> classes;
    Services sl;
    Services s2;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void create() {
        sl = ServicesFactory.chooseService("Food service",
                "Any services in a hotel delivered to a guest directly unto their rooms.", 1000.00);
        s2 = ServicesFactory.chooseService("Notifications service",
                "Any services in a hotel delivered to a guest directly unto their rooms.", 50.00);
        Services s = this.classRepository.save(sl);
        Assert.assertEquals(sl.getServName(), s.getServName());
        Services ss = this.classRepository.save(s2);
        Assert.assertEquals(s2.getServName(), ss.getServName());
    }

    @Test
    public void read() {
        String s = "Food service";
        Services s1 = this.classRepository.findById(s).orElse(null);

        Assert.assertEquals(s, s1.getServName());
        System.out.println(s1.getServName() + " " + s1.getPrice());
    }

    @Test
    public void update()
    {
        sl = ServicesFactory.chooseService("Food service",
                "Any services in a hotel delivered to a guest directly unto their rooms.", 1000.00);
        Services s = this.classRepository.save(sl);
        Assert.assertEquals(sl.getServName(), s.getServName());
        System.out.println(s.getServName() + "\n" + s.getPrice());
    }

    @Test
    public void delete()
    {
        String s = "Food service";
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