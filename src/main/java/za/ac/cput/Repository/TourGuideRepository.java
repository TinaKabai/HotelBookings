package za.ac.cput.Repository;

import za.ac.cput.Domain.Tour.TourGuide;

import java.util.Set;

public interface TourGuideRepository extends IRepository<TourGuide, String> {

    Set<TourGuide> getAll();
}
