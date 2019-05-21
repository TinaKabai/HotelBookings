package za.ac.cput.Repository;

import za.ac.cput.Domain.Tour.Attendance;

import java.util.Map;
import java.util.Set;

public interface AttendanceRepository extends IRepository<Attendance, String> {

    Map<Attendance, Attendance> getAll();
}
