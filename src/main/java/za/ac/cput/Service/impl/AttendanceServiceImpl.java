package za.ac.cput.Service.impl;

import za.ac.cput.Domain.Tour.Attendance;
import za.ac.cput.Repository.AttendanceRepository;
import za.ac.cput.Repository.Implementation.AttendanceRepositoryImpl;
import za.ac.cput.Service.AttendanceService;

import java.util.Map;

public class AttendanceServiceImpl implements AttendanceService {

    private AttendanceServiceImpl service = null;
    private AttendanceRepository repository;

    private AttendanceServiceImpl(){
        this.repository = AttendanceRepositoryImpl.getRepository();
    }

    public AttendanceRepository getService(){
        if (service == null) service = new AttendanceServiceImpl();
        return null;
    }

    @Override
    public Attendance create(Attendance attendance) {
        return this.repository.create(attendance);
    }

    @Override
    public Attendance update(Attendance attendance) {
        return this.repository.update(attendance);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Attendance read(String s) {
        return this.repository.read(s);
    }

    public Map<Attendance, Attendance> getAll() {
        return this.repository.getAll();
    }
}
