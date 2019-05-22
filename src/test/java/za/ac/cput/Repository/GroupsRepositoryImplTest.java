package za.ac.cput.Repository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import za.ac.cput.Domain.Tour.Groups;
import za.ac.cput.Factory.GroupsFactory;
import za.ac.cput.Repository.Implementation.GroupsRepositoryImpl;

import java.util.Map;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class GroupsRepositoryImplTest {

    private GroupsRepository repository;

    private Groups groups;

    @Before
    public void setUp() throws Exception {

        this.repository = (GroupsRepositoryImpl) GroupsRepositoryImpl.getRepository();

        this.groups = GroupsFactory.groups("Travelling", 5, 12);
    }

    @Test
    public void d_getAll() {
        Map<Groups, Groups> groups = this.repository.getAll();

        System.out.println("In getAll, all = " + groups);
    }

    @Test
    public void create() {

        Groups created = this.repository.create(this.groups);

        System.out.println("In create, created = " + created);

        Assert.assertNotNull(created);

        Assert.assertSame(created, this.groups);
    }

    @Test
    public void read() {

        Groups read = this.repository.read(groups.getGroupName());

        System.out.println("In read, read = " + read);

        d_getAll();
        Assert.assertEquals(read, groups);
    }

    @Test
    public void update() {

        String newGroup = "Photographing";

        Groups updated = new Groups.Builder().groupName(newGroup).build();

        System.out.println("In update, about_to_updated = " + updated);

        this.repository.update(updated);

        Assert.assertEquals(newGroup, updated.getGroupName());
        d_getAll();
    }

    @Test
    public void delete() {

        this.repository.delete(groups.getGroupName());
        d_getAll();
    }
}