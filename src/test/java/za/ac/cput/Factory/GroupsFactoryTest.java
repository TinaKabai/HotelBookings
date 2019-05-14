package za.ac.cput.Factory;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.Domain.Tour.Groups;

public class GroupsFactoryTest {

    @Test
    public void grouping(){

        Groups g = GroupsFactory.groups("Travelling", 5, 12);

        Assert.assertEquals("Travelling", g.getGroupName());
    }

}