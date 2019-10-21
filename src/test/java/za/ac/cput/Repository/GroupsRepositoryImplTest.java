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
import za.ac.cput.Domain.Tour.Groups;
import za.ac.cput.Factory.GroupsFactory;
import za.ac.cput.Repository.tour.GroupsRepository;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class GroupsRepositoryImplTest {

    @Autowired
    private GroupsRepository classRepository;
    private List<Groups> classes;
    Groups gl;
    Groups g2;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void create() {
        gl = GroupsFactory.groups("Travelling", 5, 12);
        g2 = GroupsFactory.groups("Hiking", 10, 5);
        Groups g = this.classRepository.save(gl);
        Assert.assertEquals(gl.getGroupName(), g.getGroupName());
        Groups gg = this.classRepository.save(g2);
        Assert.assertEquals(g2.getGroupName(), gg.getGroupName());
    }

    @Test
    public void read() {
        String s = "Travelling";
        Groups g1 = this.classRepository.findById(s).orElse(null);

        Assert.assertEquals(s, g1.getGroupName());
        System.out.println(g1.getGroupName() + " " + g1.getMembers());
    }

    @Test
    public void update()
    {
        gl = GroupsFactory.groups("Travelling", 5, 12);
        Groups g = this.classRepository.save(gl);
        Assert.assertEquals(gl.getGroupName(), g.getGroupName());
        System.out.println(g.getGroupName() + "\n" + g.getMembers());
    }

    @Test
    public void delete()
    {
        String s = "Travelling";
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