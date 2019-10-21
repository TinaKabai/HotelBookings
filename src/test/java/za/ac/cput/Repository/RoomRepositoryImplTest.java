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
import za.ac.cput.Domain.Content.Room;
import za.ac.cput.Factory.RoomFactory;
import za.ac.cput.Repository.content.RoomRepository;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class RoomRepositoryImplTest {

    @Autowired
    private RoomRepository classRepository;
    private List<Room> classes;
    Room rl;
    Room r2;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void create() {
        rl = RoomFactory.findRoom(525, " double", "available", 5, 900.00);
        r2 = RoomFactory.findRoom(313, " single", "not available", 3, 300.00);
        Room r = this.classRepository.save(rl);
        Assert.assertEquals(rl.getRoomNo(), r.getRoomNo());
        Room rr = this.classRepository.save(r2);
        Assert.assertEquals(r2.getRoomNo(), rr.getRoomNo());
    }

    @Test
    public void read() {
        String s = "525";
        Room r1 = this.classRepository.findById(s).orElse(null);

        Assert.assertEquals(s, r1.getRoomNo());
        System.out.println(r1.getRoomNo() + " " + r1.getRoomType() + " " + r1.getFloor());
    }

    @Test
    public void update()
    {
        rl = RoomFactory.findRoom(525, " double", "available", 5, 900.00);
        Room r = this.classRepository.save(rl);
        Assert.assertEquals(rl.getRoomNo(), r.getRoomNo());
        System.out.println(r.getRoomNo() + "\n" + r.getRoomType() + "\n" + r.getFloor());
    }

    @Test
    public void delete()
    {
        String s = "525";
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