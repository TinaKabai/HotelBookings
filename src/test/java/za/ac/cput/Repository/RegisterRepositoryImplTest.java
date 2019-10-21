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
import za.ac.cput.Domain.Users.Register;
import za.ac.cput.Factory.RegisterFactory;
import za.ac.cput.Repository.users.RegisterRepository;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class RegisterRepositoryImplTest {

    @Autowired
    private RegisterRepository classRepository;
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
        r2 = RegisterFactory.registration("Nkosinati", "Nkosi", "03 March 998", "NK", "N1998",
                "N1998");
        Register r = this.classRepository.save(rl);
        Assert.assertEquals(rl.getUsername(), r.getUsername());
        Register rr = this.classRepository.save(r2);
        Assert.assertEquals(r2.getUsername(), rr.getUsername());
    }

    @Test
    public void read() {
        String s = "TKL";
        Register r1 = this.classRepository.findById(s).orElse(null);

        Assert.assertEquals(s, r1.getUsername());
        System.out.println(r1.getUsername() + " " + r1.getPassword() + " " + r1.getFisrtName());
    }

    @Test
    public void update()
    {
        rl = RegisterFactory.registration("Thato", "Kabai", "17 Feb 2002", "TKL", "TK2002",
                "TK2002");
        Register r = this.classRepository.save(rl);
        Assert.assertEquals(rl.getUsername(), r.getUsername());
        System.out.println(r.getUsername() + "\n" + r.getPassword() + "\n" + r.getFisrtName());
    }

    @Test
    public void delete()
    {
        String s = "TKL";
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