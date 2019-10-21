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
import za.ac.cput.Domain.Users.Login;
import za.ac.cput.Factory.LoginFactory;
import za.ac.cput.Repository.users.LoginRepository;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class LoginRepositoryImplTest {

    @Autowired
    private LoginRepository classRepository;
    private List<Login> classes;
    Login ll;
    Login l2;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void create() {
        ll = LoginFactory.login("TinaN", "980303T");
        l2 = LoginFactory.login("NkosiK", "980918N");
        Login l = this.classRepository.save(ll);
        Assert.assertEquals(ll.getUsername(), l.getUsername());
        Login ll = this.classRepository.save(l2);
        Assert.assertEquals(l2.getUsername(), ll.getUsername());
    }

    @Test
    public void read() {
        String s = "TinaN";
        Login l1 = this.classRepository.findById(s).orElse(null);

        Assert.assertEquals(s, l1.getUsername());
        System.out.println(l1.getUsername() + " " + l1.getPassword());
    }

    @Test
    public void update()
    {
        ll = LoginFactory.login("TinaN", "980303T");
        Login l = this.classRepository.save(ll);
        Assert.assertEquals(ll.getUsername(), l.getUsername());
        System.out.println(l.getUsername() + "\n" + l.getPassword());
    }

    @Test
    public void delete()
    {
        String s = "TinaN";
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