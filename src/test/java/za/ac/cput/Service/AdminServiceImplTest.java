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
import za.ac.cput.Domain.Users.Admin;
import za.ac.cput.Factory.AdminFactory;
import za.ac.cput.Service.Users.implementations.AdminServiceImpl;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class AdminServiceImplTest {

    @Autowired
    private AdminServiceImpl service;
    private List<Admin> classes;
    Admin al;
    Admin a2;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void create() {
        al = AdminFactory.adminlogin("980303T", "Nkosi6991");
        Admin a = this.service.create(al);
        Assert.assertEquals(al.getID(), a.getID());
    }

    @Test
    public void read() {
        String s = "980303T";
        Admin al = this.service.read(s);

        Assert.assertEquals(s, al.getID());
        System.out.println(al.getID() + " " + al.getPassword());
    }

    @Test
    public void update() {
        al = AdminFactory.adminlogin("980303T", "Nkosi6991");
        Admin a = this.service.update(al);
        Assert.assertEquals(al.getID(), a.getID());
        System.out.println(a.getID() + "\n" + a.getPassword());
    }

    @Test
    public void delete() {
        String s = "980303T";
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