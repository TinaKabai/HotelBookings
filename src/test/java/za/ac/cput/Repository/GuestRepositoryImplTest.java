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
import za.ac.cput.Domain.Content.Guest;
import za.ac.cput.Factory.GuestFactory;
import za.ac.cput.Repository.content.GuestRepository;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class GuestRepositoryImplTest {

    @Autowired
    private GuestRepository classRepository;
    private List<Guest> classes;
    Guest gl;
    Guest g2;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void create() {
        gl = GuestFactory.findGuest("Tina", "0731906340", "10 Dorset Street");
        g2 = GuestFactory.findGuest("Nkosi", "0731915486", "141 Forest Street");
        Guest g = this.classRepository.save(gl);
        Assert.assertEquals(gl.getName(), g.getName());
        Guest gg = this.classRepository.save(g2);
        Assert.assertEquals(g2.getName(), gg.getName());
    }

    @Test
    public void read() {
        String s = "Tina";
        Guest g1 = this.classRepository.findById(s).orElse(null);

        Assert.assertEquals(s, g1.getName());
        System.out.println(g1.getName() + " " + g1.getNumber());
    }

    @Test
    public void update()
    {
        gl = GuestFactory.findGuest("Tina", "0731906340", "10 Dorset Street");
        Guest g = this.classRepository.save(gl);
        Assert.assertEquals(gl.getName(), g.getName());
        System.out.println(g.getName() + "\n" + g.getNumber());
    }

    @Test
    public void delete()
    {
        String s = "Tina";
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