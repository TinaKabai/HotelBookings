package za.ac.cput.Factory;

import za.ac.cput.Domain.Tour.Attendance;

public class AttendanceFactory {
    public static Attendance attendingGuests(boolean attending){
        return new Attendance.Builder().attend(attending).build();
    }
}
