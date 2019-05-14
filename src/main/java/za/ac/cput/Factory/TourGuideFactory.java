package za.ac.cput.Factory;

import za.ac.cput.Domain.Tour.TourGuide;

public class TourGuideFactory {

    public static TourGuide guide(String guideName, boolean availability){

        return new TourGuide.Builder().name(guideName).availability(availability).build();
    }
}
