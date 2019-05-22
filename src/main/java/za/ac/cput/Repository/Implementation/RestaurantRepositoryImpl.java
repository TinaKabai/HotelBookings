package za.ac.cput.Repository.Implementation;

import za.ac.cput.Domain.Content.Restaurant;
import za.ac.cput.Repository.RestaurantRepository;

import java.util.HashSet;
import java.util.Set;

public class RestaurantRepositoryImpl implements RestaurantRepository {

    private static RestaurantRepositoryImpl repository = null;
    private Set<Restaurant> restaurants;

    private RestaurantRepositoryImpl() {
        this.restaurants = new HashSet<>();
    }

    private Restaurant theRestaurant(String restName) {
        return this.restaurants.stream()
                .filter(restaurant -> restaurant.getRestuName().trim().equals(restName))
                .findAny()
                .orElse(null);
    }

    public static RestaurantRepositoryImpl getRepository() {
        if (repository == null) repository = new RestaurantRepositoryImpl();
        return repository;
    }

    public Restaurant read(final String restName){
        Restaurant restaurant = theRestaurant(restName);
        return restaurant;
    }

    public void delete(String restName) {
        Restaurant restaurant = theRestaurant(restName);
        if (restaurant != null) this.restaurants.remove(restaurant);
    }

    @Override
    public Restaurant create(Restaurant restaurant) {
        return restaurant;
    }

    public Restaurant update(Restaurant restaurant){
        Restaurant toDelete = theRestaurant(restaurant.getRestuName());
        if(toDelete != null) {
            this.restaurants.remove(toDelete);
            return create(restaurant);
        }
        return null;
    }

    public Set<Restaurant> getAll(){
        return this.restaurants;
    }
}
