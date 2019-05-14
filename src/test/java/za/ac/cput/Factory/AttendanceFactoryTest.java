package za.ac.cput.Factory;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.Domain.Tour.Attendance;

public class AttendanceFactoryTest{

    @Test
    public void attend(){

        Attendance attendance = AttendanceFactory.attendingGuests(true);

        Assert.assertNotNull(attendance.equals(true));
    }

}