package za.ac.cput.Service.impl;

import za.ac.cput.Domain.Tour.TourGuide;
import za.ac.cput.Repository.Implementation.TourGuideRepositoryImpl;
import za.ac.cput.Repository.TourGuideRepository;
import za.ac.cput.Service.TourGuideService;

import java.util.Set;

public class TourGuideServiceImpl {

    private TourGuideServiceImpl service = null;
    private TourGuideRepository repository;

    private TourGuideServiceImpl(){
        this.repository = TourGuideRepositoryImpl.getRepository();
    }

    public TourGuideService getService(){
        if (service == null) service = new TourGuideServiceImpl();
        return null;
    }

    //@Override
    public TourGuide create(TourGuide tourGuide) {
        return this.repository.create(tourGuide);
    }

    //@Override
    public TourGuide update(TourGuide tourGuide) {
        return this.repository.update(tourGuide);
    }

    //@Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    //@Override
    public TourGuide read(String s) {
        return this.repository.read(s);
    }

    public Set<TourGuide> getAll() {
        return this.repository.getAll();
    }
}
