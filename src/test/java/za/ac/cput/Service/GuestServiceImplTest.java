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
import za.ac.cput.Domain.Content.Guest;
import za.ac.cput.Factory.GuestFactory;
import za.ac.cput.Service.Content.implementations.GuestServiceImpl;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class GuestServiceImplTest {

    @Autowired
    private GuestServiceImpl service;
    private List<Guest> classes;
    Guest gl;
    Guest g2;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void create() {
        gl = GuestFactory.findGuest("Tina", "0731906340", "10 Dorset Street");
        Guest g = this.service.create(gl);
        Assert.assertEquals(gl.getName(), g.getName());
    }

    @Test
    public void read() {
        String s = "Tina";
        Guest gl = this.service.read(s);

        Assert.assertEquals(s, gl.getName());
        System.out.println(gl.getName() + " " + gl.getNumber());
    }

    @Test
    public void update() {
        gl = GuestFactory.findGuest("Tina", "0731906340", "10 Dorset Street");
        Guest g = this.service.update(gl);
        Assert.assertEquals(gl.getName(), g.getName());
        System.out.println(g.getName() + "\n" + g.getNumber());
    }

    @Test
    public void delete() {
        String s = "Tina";
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