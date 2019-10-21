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
import za.ac.cput.Domain.Users.Register;
import za.ac.cput.Factory.RegisterFactory;
import za.ac.cput.Service.Users.implementations.RegisterServiceImpl;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class RegisterServiceImplTest {

    @Autowired
    private RegisterServiceImpl service;
    private List<Register> classes;
    Register rl;
    Register r2;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void create() {
        rl = RegisterFactory.registration("Thato", "Kabai", "17 Feb 2002", "TKL", "TK2002",
                "TK2002");
        Register r = this.service.create(rl);
        Assert.assertEquals(rl.getUsername(), r.getUsername());
    }

    @Test
    public void read() {
        String s = "Thato";
        Register rl = this.service.read(s);

        Assert.assertEquals(s, rl.getUsername());
        System.out.println(rl.getUsername() + " " + rl.getPassword());
    }

    @Test
    public void update() {
        rl = RegisterFactory.registration("Thato", "Kabai", "17 Feb 2002", "TKL", "TK2002",
                "TK2002");
        Register r = this.service.update(rl);
        Assert.assertEquals(rl.getUsername(), r.getUsername());
        System.out.println(r.getUsername() + "\n" + r.getPassword());
    }

    @Test
    public void delete() {
        String s = "Thato";
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