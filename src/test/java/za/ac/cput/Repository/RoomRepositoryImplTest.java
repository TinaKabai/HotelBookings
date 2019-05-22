package za.ac.cput.Repository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import za.ac.cput.Domain.Content.Room;
import za.ac.cput.Factory.RoomFactory;
import za.ac.cput.Repository.Implementation.RoomRepositoryImpl;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class RoomRepositoryImplTest {

    private RoomRepository repository;

    private Room room;

    @Before
    public void setUp() throws Exception {

        this.repository = (RoomRepositoryImpl) RoomRepositoryImpl.getRepository();

        this.room = RoomFactory.findRoom(525, " double", "available", 3, 900.00);
    }

    @Test
    public void d_getAll() {
        Set<Room> room = this.repository.getAll();

        System.out.println("In getAll, all = " + room);
    }

    @Test
    public void create() {

        Room created = this.repository.create(this.room);

        System.out.println("In create, created = " + created);

        Assert.assertNotNull(created);

        Assert.assertSame(created, this.room);
    }

    @Test
    public void read() {

        Room read = this.repository.read(room.getRoomType());

        System.out.println("In read, read = " + read);

        d_getAll();
        Assert.assertEquals(read, room);
    }

    @Test
    public void update() {

        String newRoom = "Single";

        Room updated = new Room.Builder().roomType(newRoom).build();

        System.out.println("In update, about_to_updated = " + updated);

        this.repository.update(updated);

        Assert.assertEquals(newRoom, updated.getRoomType());
        d_getAll();
    }

    @Test
    public void delete() {

        this.repository.delete(room.getRoomType());
        d_getAll();
    }
}