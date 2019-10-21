package za.ac.cput.Service.Tour;

import za.ac.cput.Domain.Tour.Groups;
import za.ac.cput.Service.GenIService;

import java.util.List;

public interface TourGuideService extends GenIService<TourGuideService, String> {

    Groups retrieveById(String id);
    List<Groups> getAll();
}
