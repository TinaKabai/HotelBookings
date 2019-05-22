package za.ac.cput.Repository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import za.ac.cput.Domain.Content.Deluxe;
import za.ac.cput.Factory.DeluxeFactory;
import za.ac.cput.Repository.Implementation.DeluxeRepositoryImpl;

import java.util.Map;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class DeluxeRepositoryImplTest {

    private DeluxeRepository repository;

    private Deluxe deluxe;

    @Before
    public void setUp() throws Exception {

        this.repository = (DeluxeRepositoryImpl) DeluxeRepositoryImpl.getRepository();

        this.deluxe = DeluxeFactory.delux(true);
    }

    @Test
    public void d_getAll() {
        Map<Deluxe, Deluxe> deluxe = this.repository.getAll();

        System.out.println("In getAll, all = " + deluxe);
    }

    @Test
    public void create() {

        Deluxe created = this.repository.create(this.deluxe);

        System.out.println("In create, created = " + created);

        Assert.assertNotNull(created);

        Assert.assertSame(created, this.deluxe);
    }

    @Test
    public void read() {

        Deluxe read = this.repository.read(deluxe.getRoomType());

        System.out.println("In read, read = " + read);

        d_getAll();
        Assert.assertEquals(read, deluxe);
    }

    @Test
    public void update() {

        boolean newDeluxe = true;

        Deluxe updated = new Deluxe.Builder().deluxe(newDeluxe).build();

        System.out.println("In update, about_to_updated = " + updated);

        this.repository.update(updated);

        Assert.assertEquals(newDeluxe, updated.isDeluxe());
        d_getAll();
    }

    @Test
    public void delete() {

        this.repository.delete(deluxe.getRoomType());
        d_getAll();
    }
}