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
import za.ac.cput.Domain.Content.Suite;
import za.ac.cput.Factory.SuiteFactory;
import za.ac.cput.Repository.content.SuiteRepository;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class SuiteRepositoryImplTest {

    @Autowired
    private SuiteRepository classRepository;
    private List<Suite> classes;
    Suite sl;
    Suite s2;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void create() {
        sl = SuiteFactory.suites(true);
        s2 = SuiteFactory.suites(false);
        Suite s = this.classRepository.save(sl);
        Assert.assertEquals(sl.isSuite(), s.isSuite());
        Suite ss = this.classRepository.save(s2);
        Assert.assertEquals(s2.isSuite(), ss.isSuite());
    }

    @Test
    public void read() {
        String s = "true";
        Suite s1 = this.classRepository.findById(s).orElse(null);

        Assert.assertEquals(s, s1.isSuite());
        System.out.println(s1.isSuite());
    }

    @Test
    public void update()
    {
        sl = SuiteFactory.suites(true);
        Suite s = this.classRepository.save(sl);
        Assert.assertEquals(sl.isSuite(), s.isSuite());
        System.out.println(s.isSuite() + "\n" + s.isSuite());
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