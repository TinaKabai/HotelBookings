package za.ac.cput.Repository.Implementation;

import za.ac.cput.Domain.Tour.TourGuide;
import za.ac.cput.Repository.TourGuideRepository;

import java.util.HashSet;
import java.util.Set;

public class TourGuideRepositoryImpl implements TourGuideRepository {

    private static TourGuideRepositoryImpl repository = null;
    private Set<TourGuide> tourGuides;

    private TourGuideRepositoryImpl() {
        this.tourGuides = new HashSet<>();
    }

    private TourGuide showGuide(String guideName) {
        return this.tourGuides.stream()
                .filter(hotel -> hotel.getName().trim().equals(guideName))
                .findAny()
                .orElse(null);
    }

    public static TourGuideRepositoryImpl getRepository() {
        if (repository == null) repository = new TourGuideRepositoryImpl();
        return repository;
    }

    public TourGuide create(TourGuide tourGuide){
        this.tourGuides.add(tourGuide);
        return tourGuide;
    }

    public TourGuide read(final String guideName){
        TourGuide tourGuide = showGuide(guideName);
        return tourGuide;
    }

    public void delete(String guideName) {
        TourGuide tourGuide = showGuide(guideName);
        if (guideName != null) this.tourGuides.remove(tourGuide);
    }

    public TourGuide update(TourGuide tourGuide){
        TourGuide toDelete = showGuide(tourGuide.getName());
        if(toDelete != null) {
            this.tourGuides.remove(toDelete);
            return create(tourGuide);
        }
        return null;
    }


    public Set<TourGuide> getAll(){
        return this.tourGuides;
    }
}
