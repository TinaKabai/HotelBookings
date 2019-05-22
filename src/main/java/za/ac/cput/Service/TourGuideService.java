package za.ac.cput.Service;

import za.ac.cput.Domain.Tour.Groups;

import java.util.Set;

public interface TourGuideService extends IService<TourGuideService, String> {

    Set<Groups> getAll();
}
