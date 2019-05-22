package za.ac.cput.Service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import za.ac.cput.Domain.Content.Guest;
import za.ac.cput.Factory.GuestFactory;
import za.ac.cput.Repository.GuestRepository;
import za.ac.cput.Repository.Implementation.GuestRepositoryImpl;

import java.util.Map;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class GuestServiceImplTest {

    private GuestRepository repository;

    private Guest guest;

    @Before
    public void setUp() throws Exception {

        this.repository = (GuestRepositoryImpl) GuestRepositoryImpl.getRepository();

        this.guest = GuestFactory.findGuest("Sebe", "0731906340", "10 Dorset Street");
    }

    @Test
    public void d_getAll() {
        Map<Guest, Guest> guest = this.repository.getAll();

        System.out.println("In getAll, all = " + guest);
    }

    @Test
    public void create() {

        Guest created = this.repository.create(this.guest);

        System.out.println("In create, created = " + created);

        Assert.assertNotNull(created);

        Assert.assertSame(created, this.guest);
    }

    @Test
    public void read() {

        Guest read = this.repository.read(guest.getName());

        System.out.println("In read, read = " + read);

        d_getAll();
        Assert.assertEquals(read, guest);
    }

    @Test
    public void update() {

        String newGuest = "Tina";

        Guest updated = new Guest.Builder().name(newGuest).build();

        System.out.println("In update, about_to_updated = " + updated);

        this.repository.update(updated);

        Assert.assertEquals(newGuest, updated.getName());
        d_getAll();
    }

    @Test
    public void delete() {

        this.repository.delete(guest.getName());
        d_getAll();
    }
}