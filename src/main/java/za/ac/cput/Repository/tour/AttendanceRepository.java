package za.ac.cput.Repository.tour;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Domain.Tour.Attendance;

import java.util.Map;
import java.util.Set;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, String> {

    //Map<Attendance, Attendance> getAll();
}
