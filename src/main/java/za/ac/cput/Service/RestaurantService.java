package za.ac.cput.Service;

import za.ac.cput.Domain.Content.Restaurant;

import java.util.Set;

public interface RestaurantService extends IService<Restaurant, String> {

    Set<Restaurant> getAll();
}
