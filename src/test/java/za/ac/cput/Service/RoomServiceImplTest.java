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
import za.ac.cput.Domain.Content.Room;
import za.ac.cput.Factory.RoomFactory;
import za.ac.cput.Service.Content.implementations.RoomServiceImpl;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class RoomServiceImplTest {

    @Autowired
    private RoomServiceImpl service;
    private List<Room> classes;
    Room rl;
    Room r2;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void create() {
        rl = RoomFactory.findRoom(525, " double", "available", 5, 900.00);
        Room r = this.service.create(rl);
        Assert.assertEquals(rl.getRoomNo(), r.getRoomNo());
    }

    @Test
    public void read() {
        String s = "525";
        Room rl = this.service.read(s);

        Assert.assertEquals(s, rl.getRoomNo());
        System.out.println(rl.getRoomNo() + " " + rl.getRoomType());
    }

    @Test
    public void update() {
        rl = RoomFactory.findRoom(525, " double", "available", 5, 900.00);
        Room r = this.service.update(rl);
        Assert.assertEquals(rl.getRoomNo(), r.getRoomNo());
        System.out.println(r.getRoomNo() + "\n" + r.getFloor());
    }

    @Test
    public void delete() {
        String s = "525";
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