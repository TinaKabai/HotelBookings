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
import za.ac.cput.Domain.Tour.Groups;
import za.ac.cput.Factory.GroupsFactory;
import za.ac.cput.Service.Tour.implementations.GroupsServiceImpl;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class GroupsServiceImplTest {

    @Autowired
    private GroupsServiceImpl service;
    private List<Groups> classes;
    Groups gl;
    Groups g2;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void create() {
        gl = GroupsFactory.groups("Travelling", 5, 12);
        Groups g = this.service.create(gl);
        Assert.assertEquals(gl.getGroupName(), g.getGroupName());
    }

    @Test
    public void read() {
        String s = "Travelling";
        Groups gl = this.service.read(s);

        Assert.assertEquals(s, gl.getGroupName());
        System.out.println(gl.getGroupName() + " " + gl.getMembers());
    }

    @Test
    public void update() {
        gl = GroupsFactory.groups("Travelling", 5, 12);
        Groups g = this.service.update(gl);
        Assert.assertEquals(gl.getGroupName(), g.getGroupName());
        System.out.println(g.getGroupName() + "\n" + g.getMembers());
    }

    @Test
    public void delete() {
        String s = "Travelling";
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