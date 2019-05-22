package za.ac.cput.Service;

import za.ac.cput.Domain.Tour.Attendance;

import java.util.Map;

public interface AttendanceService extends IService<Attendance, String> {

    Map<Attendance, Attendance> getAll();
}
