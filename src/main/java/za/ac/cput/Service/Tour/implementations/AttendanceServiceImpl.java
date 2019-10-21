package za.ac.cput.Service.Tour.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Tour.Attendance;
import za.ac.cput.Repository.tour.AttendanceRepository;
import za.ac.cput.Service.Tour.AttendanceService;

import java.util.List;
import java.util.Map;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    private static AttendanceService service = null;

    @Autowired
    private AttendanceRepository repo;

    private AttendanceServiceImpl(){

    }

    public static AttendanceService getService()
    {
        if(service == null) service = new AttendanceServiceImpl();
        return service;
    }

    @Override
    public Attendance retrieveById(String id)
    {
        List<Attendance> attendance = getAll();
        for(Attendance a: attendance) {
            if (a.getName().equals(id))
                return a;
        }
        return null;
    }

    @Override
    public List<Attendance> getAll() {
        return this.repo.findAll();
    }

    @Override
    public Attendance create(Attendance attendance) {
        return this.repo.save(attendance);
    }

    public Attendance read(String s) {
        return this.repo.findById(s).orElse(null);
    }

    @Override
    public Attendance update(Attendance attendance) {
        return this.repo.save(attendance);
    }

    public void delete(String s) {
        this.repo.deleteById(s);
    }
}
