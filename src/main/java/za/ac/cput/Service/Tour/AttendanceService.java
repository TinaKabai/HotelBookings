package za.ac.cput.Service.Tour;

import za.ac.cput.Domain.Tour.Attendance;
import za.ac.cput.Service.GenIService;

import java.util.List;
import java.util.Map;

public interface AttendanceService extends GenIService<Attendance, String> {

    Attendance retrieveById(String id);
    List<Attendance> getAll();
}
