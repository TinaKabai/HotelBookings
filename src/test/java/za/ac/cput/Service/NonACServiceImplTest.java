package za.ac.cput.Service;


import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import za.ac.cput.Domain.Content.NonAC;
import za.ac.cput.Factory.NonACFactory;
import za.ac.cput.Repository.Implementation.NonACRepositoryImpl;
import za.ac.cput.Repository.NonACRepository;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class NonACServiceImplTest {

    private NonACRepository repository;

    private NonAC nonAC;

    @Before
    public void setUp() throws Exception {

        this.repository = (NonACRepositoryImpl) NonACRepositoryImpl.getRepository();

        this.nonAC = NonACFactory.accessibility(true);
    }

    @Test
    public void d_getAll() {
        Set<NonAC> nonAC = this.repository.getAll();

        System.out.println("In getAll, all = " + nonAC);
    }

    @Test
    public void create() {

        NonAC created = this.repository.create(this.nonAC);

        System.out.println("In create, created = " + created);

        Assert.assertNotNull(created);

        Assert.assertSame(created, this.nonAC);
    }

    @Test
    public void read() {

        NonAC read = this.repository.read(nonAC.getRoomType());

        System.out.println("In read, read = " + read);

        d_getAll();
        Assert.assertEquals(read, nonAC);
    }

    @Test
    public void update() {

        boolean newNonAC = true;

        NonAC updated = new NonAC.Builder().nonAC(newNonAC).build();

        System.out.println("In update, about_to_updated = " + updated);

        this.repository.update(updated);

        Assert.assertEquals(newNonAC, updated.isNonAC());
        d_getAll();
    }

    @Test
    public void delete() {

        this.repository.delete(nonAC.getRoomType());
        d_getAll();
    }
}