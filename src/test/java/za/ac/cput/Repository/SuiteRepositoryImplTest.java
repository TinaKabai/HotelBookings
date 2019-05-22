package za.ac.cput.Repository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import za.ac.cput.Domain.Content.Suite;
import za.ac.cput.Factory.SuiteFactory;
import za.ac.cput.Repository.Implementation.SuiteRepositoryImpl;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class SuiteRepositoryImplTest {

    private SuiteRepository repository;

    private Suite suite;

    @Before
    public void setUp() throws Exception {

        this.repository = (SuiteRepositoryImpl) SuiteRepositoryImpl.getRepository();

        this.suite = SuiteFactory.suites(true);
    }

    @Test
    public void d_getAll() {
        Set<Suite> suite = this.repository.getAll();

        System.out.println("In getAll, all = " + suite);
    }

    @Test
    public void create() {

        Suite created = this.repository.create(this.suite);

        System.out.println("In create, created = " + created);

        Assert.assertNotNull(created);

        Assert.assertSame(created, this.suite);
    }

    @Test
    public void read() {

        Suite read = this.repository.read(suite.getRoomType());

        System.out.println("In read, read = " + read);

        d_getAll();
        Assert.assertEquals(read, suite);
    }

    @Test
    public void update() {

        boolean newSuite = true;

        Suite updated = new Suite.Builder().suite(newSuite).build();

        System.out.println("In update, about_to_updated = " + updated);

        this.repository.update(updated);

        Assert.assertEquals(newSuite, updated.isSuite());
        d_getAll();
    }

    @Test
    public void delete() {

        this.repository.delete(suite.getRoomType());
        d_getAll();
    }
}