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
import za.ac.cput.Domain.Users.Admin;
import za.ac.cput.Factory.AdminFactory;
import za.ac.cput.Repository.users.AdminRepository;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class AdminRepositoryImplTest {

    @Autowired
    private AdminRepository classRepository;
    private List<Admin> classes;
    Admin al;
    Admin a2;

    @Before
    public void setUp() throws Exception
    {
        //this.classRepository = ChurchRepositoryImplementation.getRepository();
    }

    @Test
    public void create()
    {
        al = AdminFactory.adminlogin("980303T", "Nkosi6991");
        a2 = AdminFactory.adminlogin("960918N", "Tina1998");
        Admin a = this.classRepository.save(al);
        Assert.assertEquals(al.getID(), a.getID());
        Admin aa = this.classRepository.save(a2);
        Assert.assertEquals(a2.getID(), aa.getID());
    }

    @Test
    public void read()
    {
        String s = "980303T";
        Admin a1 = this.classRepository.findById(s).orElse(null);

        Assert.assertEquals(s, al.getID());
        System.out.println(a1.getID() + " " + a1.getPassword());
    }

    @Test
    public void update()
    {
        al = AdminFactory.adminlogin("980303T", "Nkosi6991");
        Admin a = this.classRepository.save(al);
        Assert.assertEquals(al.getID(), a.getID());
        System.out.println(a.getID() + "\n" + a.getPassword());
    }

    @Test
    public void delete()
    {
        String s = "980303T";
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