package za.ac.cput.Service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import za.ac.cput.Domain.Tour.TourGuide;
import za.ac.cput.Factory.TourGuideFactory;
import za.ac.cput.Repository.Implementation.TourGuideRepositoryImpl;
import za.ac.cput.Repository.TourGuideRepository;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class TourGuideServiceImplTest{

    private TourGuideRepository repository;

    private TourGuide tourGuide;

    @Before
    public void setUp() throws Exception {

        this.repository = (TourGuideRepositoryImpl) TourGuideRepositoryImpl.getRepository();

        this.tourGuide = TourGuideFactory.guide("Bongeka", true);
    }

    @Test
    public void d_getAll() {
        Set<TourGuide> tourGuide = this.repository.getAll();

        System.out.println("In getAll, all = " + tourGuide);
    }

    @Test
    public void create() {

        TourGuide created = this.repository.create(this.tourGuide);

        System.out.println("In create, created = " + created);

        Assert.assertNotNull(created);

        Assert.assertSame(created, this.tourGuide);
    }

    @Test
    public void read() {

        TourGuide read = this.repository.read(tourGuide.getName());

        System.out.println("In read, read = " + read);

        d_getAll();
        Assert.assertEquals(read, tourGuide);
    }

    @Test
    public void update() {

        String newGuide = "Owethu";

        TourGuide updated = new TourGuide.Builder().name(newGuide).build();

        System.out.println("In update, about_to_updated = " + updated);

        this.repository.update(updated);

        Assert.assertEquals(newGuide, updated.getName());
        d_getAll();
    }

    @Test
    public void delete() {

        this.repository.delete(tourGuide.getName());
        d_getAll();
    }
}