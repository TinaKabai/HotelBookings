package za.ac.cput.Repository;

import za.ac.cput.Domain.Content.Restaurant;

import java.util.Set;

public interface RestaurantRepository extends IRepository<Restaurant, String> {

    Set<Restaurant> getAll();
}
