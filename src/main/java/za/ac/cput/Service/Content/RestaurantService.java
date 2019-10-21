package za.ac.cput.Service.Content;

import za.ac.cput.Domain.Content.Restaurant;
import za.ac.cput.Service.GenIService;

import java.util.List;
import java.util.Set;

public interface RestaurantService extends GenIService<Restaurant, String> {

    Restaurant retrieveById(String id);
    List<Restaurant> getAll();
}
