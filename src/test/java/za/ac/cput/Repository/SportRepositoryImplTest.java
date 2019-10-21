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
import za.ac.cput.Domain.Activites.Sport;
import za.ac.cput.Factory.SportFactory;
import za.ac.cput.Repository.activities.SportRepository;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class SportRepositoryImplTest {

    @Autowired
    private SportRepository classRepository;
    private List<Sport> classes;
    Sport sl;
    Sport s2;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void create() {
        sl = SportFactory.findSport("Rugby", "Tina", 30, "Cape Sun Hotel");
        s2 = SportFactory.findSport("Netball", "Nkosi", 14, "The Peninsula All-Suite Hotel");
        Sport s = this.classRepository.save(sl);
        Assert.assertEquals(sl.getSportName(), s.getSportName());
        Sport ss = this.classRepository.save(s2);
        Assert.assertEquals(s2.getSportName(), ss.getSportName());
    }

    @Test
    public void read() {
        String s = "Rugby";
        Sport s1 = this.classRepository.findById(s).orElse(null);

        Assert.assertEquals(s, s1.getSportName());
        System.out.println(s1.getSportName() + " " + s1.getNoParticipants());
    }

    @Test
    public void update()
    {
        sl = SportFactory.findSport("Rugby", "Tina", 30, "Cape Sun Hotel");
        Sport s = this.classRepository.save(sl);
        Assert.assertEquals(sl.getSportName(), s.getSportName());
        System.out.println(s.getSportName() + "\n" + s.getNoParticipants());
    }

    @Test
    public void delete()
    {
        String s = "Rugby";
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