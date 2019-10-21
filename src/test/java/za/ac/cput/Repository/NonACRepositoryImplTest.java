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
import za.ac.cput.Domain.Content.NonAC;
import za.ac.cput.Factory.NonACFactory;
import za.ac.cput.Repository.content.NonACRepository;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class NonACRepositoryImplTest {

    @Autowired
    private NonACRepository classRepository;
    private List<NonAC> classes;
    NonAC nl;
    NonAC n2;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void create() {
        nl = NonACFactory.accessibility(true);
        n2 = NonACFactory.accessibility(false);
        NonAC n = this.classRepository.save(nl);
        Assert.assertEquals(nl.isNonAC(), n.isNonAC());
        NonAC nn = this.classRepository.save(n2);
        Assert.assertEquals(n2.isNonAC(), nn.isNonAC());
    }

    @Test
    public void read() {
        String s = "true";
        NonAC n1 = this.classRepository.findById(s).orElse(null);

        Assert.assertEquals(s, n1.isNonAC());
        System.out.println(n1.isNonAC());
    }

    @Test
    public void update()
    {
        nl = NonACFactory.accessibility(true);
        NonAC n = this.classRepository.save(nl);
        Assert.assertEquals(nl.isNonAC(), n.isNonAC());
        System.out.println(n.isNonAC());
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