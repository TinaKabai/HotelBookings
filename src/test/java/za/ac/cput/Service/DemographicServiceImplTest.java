package za.ac.cput.Service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import za.ac.cput.Domain.Content.Demographic;
import za.ac.cput.Factory.DemographicFactory;
import za.ac.cput.Repository.DemographicRepository;
import za.ac.cput.Repository.Implementation.DemographicRepositoryImpl;

import java.util.Map;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class DemographicServiceImplTest {

    private DemographicRepository repository;

    private Demographic demographic;

    @Before
    public void setUp() throws Exception {

        this.repository = (DemographicRepositoryImpl) DemographicRepositoryImpl.getRepository();

        this.demographic = DemographicFactory.identifyDemo("Black", " Sotho ", 16, " Male");
    }

    @Test
    public void d_getAll() {
        Map<Demographic, Demographic> demographic = this.repository.getAll();

        System.out.println("In getAll, all = " + demographic);
    }

    @Test
    public void create() {

        Demographic created = this.repository.create(this.demographic);

        System.out.println("In create, created = " + created);

        Assert.assertNotNull(created);

        Assert.assertSame(created, this.demographic);
    }

    @Test
    public void read() {

        Demographic read = this.repository.read(demographic.getRace());

        System.out.println("In read, read = " + read);

        d_getAll();
        Assert.assertEquals(read, demographic);
    }

    @Test
    public void update() {

        String newDemo = "White";

        Demographic updated = new Demographic.Builder().race(newDemo).build();

        System.out.println("In update, about_to_updated = " + updated);

        this.repository.update(updated);

        Assert.assertEquals(newDemo, updated.getRace());
        d_getAll();
    }

    @Test
    public void delete() {

        this.repository.delete(demographic.getRace());
        d_getAll();
    }
}