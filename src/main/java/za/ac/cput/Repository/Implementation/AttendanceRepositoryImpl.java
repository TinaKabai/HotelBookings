package za.ac.cput.Repository.Implementation;

import za.ac.cput.Domain.Tour.Attendance;
import za.ac.cput.Repository.AttendanceRepository;

import java.util.HashSet;
import java.util.Set;

public class AttendanceRepositoryImpl implements AttendanceRepository {

    private static AttendanceRepositoryImpl repository = null;
    private Set<Attendance> attendances;

    private AttendanceRepositoryImpl() {
        this.attendances = new HashSet<Attendance>();
    }

    public static AttendanceRepositoryImpl getRepository() {
        if (repository == null) repository = new AttendanceRepositoryImpl();
        return repository;
    }
    public Attendance create(Attendance attendance) {
        this.attendances.add(attendance);
        return attendance;
    }

    public Attendance read(String name) {
        // find the course that matches the id and return it if exist
        return null;
    }

    public void delete(String name) {
        // find the course, delete it if it exist
    }

    public Attendance update(Attendance attendance) {
        // find the course, update it and delete it if it exists
        return attendance;
    }

    public Set<Attendance> getAll(){
        return this.attendances;
    }
}
