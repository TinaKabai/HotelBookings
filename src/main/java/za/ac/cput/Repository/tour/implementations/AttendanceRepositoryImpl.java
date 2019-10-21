/*package za.ac.cput.Repository.Implementation;

import za.ac.cput.Domain.Tour.Attendance;
import za.ac.cput.Repository.tour.AttendanceRepository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository*/

/*public class AttendanceRepositoryImpl implements AttendanceRepository {

    private static AttendanceRepositoryImpl repository = null;
    private Map<Attendance, Attendance> attendances;

    private AttendanceRepositoryImpl() {
        this.attendances = new HashMap<>();
    }

    private Attendance attending(String guestName) {
        return this.attendances.values().stream()
                .filter(attendance -> attendance.getName().trim().equals(guestName))
                .findAny()
                .orElse(null);
    }

    public static AttendanceRepositoryImpl getRepository() {
        if (repository == null) repository = new AttendanceRepositoryImpl();
        return repository;
    }
    public Attendance create(Attendance attendance) {
        this.attendances.put(attendance, attendance);
        return attendance;
    }

    public Attendance read(final String guestName){
        Attendance attendance = attending(guestName);
        return attendance;
    }

    public void delete(String guestName) {
        Attendance attendance = attending(guestName);
        if (attendance != null) this.attendances.remove(attendance);
    }

    public Attendance update(Attendance attendance) {
        Attendance toDelete = attending(attendance.getName());
        if(toDelete != null) {
            this.attendances.remove(toDelete);
            return create(attendance);
        }
        return null;
    }

    public Map<Attendance, Attendance> getAll(){
        return this.attendances;
    }
}*/
