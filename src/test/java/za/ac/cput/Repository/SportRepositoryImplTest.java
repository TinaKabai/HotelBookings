package za.ac.cput.Repository;


import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import za.ac.cput.Domain.Activites.Sport;
import za.ac.cput.Factory.SportFactory;
import za.ac.cput.Repository.Implementation.SportRepositoryImpl;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class SportRepositoryImplTest {

    private SportRepository repository;

    private Sport sport;

    @Before
    public void setUp() throws Exception {

        this.repository = (SportRepositoryImpl) SportRepositoryImpl.getRepository();

        this.sport = SportFactory.findSport("Rugby", "Tina",
                                            30, "Cape Sun Hotel");
    }

    @Test
    public void d_getAll() {
        Set<Sport> sport = this.repository.getAll();

        System.out.println("In getAll, all = " + sport);
    }

    @Test
    public void create() {

        Sport created = this.repository.create(this.sport);

        System.out.println("In create, created = " + created);

        Assert.assertNotNull(created);

        Assert.assertSame(created, this.sport);
    }

    @Test
    public void read() {

        Sport read = this.repository.read(sport.getSportName());

        System.out.println("In read, read = " + read);

        d_getAll();
        Assert.assertEquals(read, sport);
    }

    @Test
    public void update() {

        String newSport = "Netball";

        Sport updated = new Sport.Builder().sportName(newSport).build();

        System.out.println("In update, about_to_updated = " + updated);

        this.repository.update(updated);

        Assert.assertEquals(newSport, updated.getSportName());
        d_getAll();
    }

    @Test
    public void delete() {

        this.repository.delete(sport.getSportName());
        d_getAll();
    }
}