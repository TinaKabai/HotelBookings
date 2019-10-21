package za.ac.cput.Repository.content;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Domain.Content.Restaurant;

import java.util.Set;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, String> {

    //Set<Restaurant> getAll();
}
