package za.ac.cput.Repository;


import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import za.ac.cput.Domain.Content.Services;
import za.ac.cput.Factory.ServicesFactory;
import za.ac.cput.Repository.Implementation.ServicesRepositoryImpl;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ServicesRepositoryImplTest {

    private ServicesRepository repository;

    private Services services;

    @Before
    public void setUp() throws Exception {

        this.repository = (ServicesRepositoryImpl) ServicesRepositoryImpl.getRepository();

        this.services = ServicesFactory.chooseService("Room service",
                "Any services in a hotel delivered to a guest directly unto their rooms.", 1000.00);
    }

    @Test
    public void d_getAll() {
        Set<Services> services = this.repository.getAll();

        System.out.println("In getAll, all = " + services);
    }

    @Test
    public void create() {

        Services created = this.repository.create(this.services);

        System.out.println("In create, created = " + created);

        Assert.assertNotNull(created);

        Assert.assertSame(created, this.services);
    }

    @Test
    public void read() {

        Services read = this.repository.read(services.getServName());

        System.out.println("In read, read = " + read);

        d_getAll();
        Assert.assertEquals(read, services);
    }

    @Test
    public void update() {

        String newService = "Fare Rate";

        Services updated = new Services.Builder().sName(newService).build();

        System.out.println("In update, about_to_updated = " + updated);

        this.repository.update(updated);

        Assert.assertEquals(newService, updated.getServName());
        d_getAll();
    }

    @Test
    public void delete() {

        this.repository.delete(services.getServName());
        d_getAll();
    }
}