package za.ac.cput.Factory;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.Domain.Content.Room;
import za.ac.cput.Factory.RoomFactory;

public class RoomFactoryTest {

    @Test
    public void room(){
        Room room = RoomFactory.findRoom(525, " double", "available", 3, 900.00);

        Assert.assertEquals("525 double", room.getRoomStatus(), room.getRoomType());
    }
}