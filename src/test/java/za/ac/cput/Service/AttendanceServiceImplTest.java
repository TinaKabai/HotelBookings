package za.ac.cput.Service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import za.ac.cput.Domain.Tour.Attendance;
import za.ac.cput.Factory.AttendanceFactory;
import za.ac.cput.Repository.AttendanceRepository;
import za.ac.cput.Repository.Implementation.AttendanceRepositoryImpl;

import java.util.Map;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class AttendanceServiceImplTest {

    private AttendanceRepository repository;

    private Attendance attendance;

    @Before
    public void setUp() throws Exception {

        this.repository = (AttendanceRepositoryImpl) AttendanceRepositoryImpl.getRepository();

        this.attendance = AttendanceFactory.attendingGuests(true);
    }

    @Test
    public void d_getAll() {
        Map<Attendance, Attendance> attendance = this.repository.getAll();

        System.out.println("In getAll, all = " + attendance);
    }

    @Test
    public void create() {

        Attendance created = this.repository.create(this.attendance);

        System.out.println("In create, created = " + created);

        Assert.assertNotNull(created);

        Assert.assertSame(created, this.attendance);
    }

    @Test
    public void read() {

        Attendance read = this.repository.read(attendance.getName());

        System.out.println("In read, read = " + read);

        d_getAll();
        Assert.assertEquals(read, attendance);
    }

    @Test
    public void update() {

        boolean newAttend = false;

        Attendance updated = new Attendance.Builder().attend(newAttend).build();

        System.out.println("In update, about_to_updated = " + updated);

        this.repository.update(updated);

        Assert.assertEquals(newAttend, updated.isAttending());
        d_getAll();
    }

    @Test
    public void delete() {

        this.repository.delete(attendance.getName());
        d_getAll();
    }
}