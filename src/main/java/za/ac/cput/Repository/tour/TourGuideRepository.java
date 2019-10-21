package za.ac.cput.Repository.tour;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Domain.Tour.TourGuide;

import java.util.Set;

@Repository
public interface TourGuideRepository extends JpaRepository<TourGuide, String> {

    //Set<TourGuide> getAll();
}
