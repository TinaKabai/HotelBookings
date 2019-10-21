package za.ac.cput.Service.Tour.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Tour.Groups;
import za.ac.cput.Domain.Tour.TourGuide;
import za.ac.cput.Repository.tour.TourGuideRepository;
import za.ac.cput.Service.Tour.TourGuideService;

import java.util.List;

@Service
public class TourGuideServiceImpl implements TourGuideService {

    private static TourGuideService service = null;

    @Autowired
    private TourGuideRepository repo;

    private TourGuideServiceImpl() {

    }

    public static TourGuideService getService() {
        if (service == null) service = new TourGuideServiceImpl();
        return service;
    }

    @Override
    public Groups retrieveById(String id) {
        return null;
    }

    @Override
    public List<Groups> getAll() {
        return null;
    }

    @Override
    public TourGuideService create(TourGuideService tourGuideService) {
        return null;
    }

    @Override
    public TourGuideService read(String s) {
        return null;
    }

    @Override
    public TourGuideService update(TourGuideService tourGuideService) {
        return null;
    }

    @Override
    public void delete(String s) {

    }
}
