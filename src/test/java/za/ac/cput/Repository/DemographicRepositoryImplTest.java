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
import za.ac.cput.Domain.Content.Demographic;
import za.ac.cput.Factory.DemographicFactory;
import za.ac.cput.Repository.content.DemographicRepository;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class DemographicRepositoryImplTest {

    @Autowired
    private DemographicRepository classRepository;
    private List<Demographic> classes;
    Demographic dl;
    Demographic d2;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void create() {
        dl = DemographicFactory.identifyDemo("Black", " Sotho", 16, " Male");
        d2 = DemographicFactory.identifyDemo("White", " French", 24, " Female");
        Demographic d = this.classRepository.save(dl);
        Assert.assertEquals(dl.getGender(), d.getGender());
        Demographic dd = this.classRepository.save(d2);
        Assert.assertEquals(d2.getGender(), dd.getGender());
    }

    @Test
    public void read()
    {
        String s = "Male";
        Demographic d1 = this.classRepository.findById(s).orElse(null);

        Assert.assertEquals(s, d1.getGender());
        System.out.println(d1.getGender());
    }

    @Test
    public void update()
    {
        dl = DemographicFactory.identifyDemo("Black", " Sotho", 16, " Male");
        Demographic d = this.classRepository.save(dl);
        Assert.assertEquals(dl.getGender(), d.getGender());
        System.out.println(d.getGender());
    }

    @Test
    public void delete()
    {
        String s = "Male";
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