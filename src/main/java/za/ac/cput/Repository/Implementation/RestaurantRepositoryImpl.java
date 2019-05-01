package za.ac.cput.Repository.Implementation;

import za.ac.cput.Domain.Content.Restaurant;
import za.ac.cput.Repository.RestaurantRepository;

import java.util.HashSet;
import java.util.Set;

public class RestaurantRepositoryImpl implements RestaurantRepository {

    private static RestaurantRepositoryImpl repository = null;
    private Set<Restaurant> restaurants;

    private RestaurantRepositoryImpl() {
        this.restaurants = new HashSet<Restaurant>();
    }

    public static RestaurantRepositoryImpl getRepository() {
        if (repository == null) repository = new RestaurantRepositoryImpl();
        return repository;
    }


    public Restaurant create(Restaurant restaurant) {
        this.restaurants.add(restaurant);
        return restaurant;
    }

    public Restaurant read(String restuName) {
        // find the course that matches the id and return it if exist
        return null;
    }

    public void delete(String restuName) {
        // find the course, delete it if it exist
    }

    public Restaurant update(Restaurant restaurant) {
        // find the course, update it and delete it if it exists
        return restaurant;
    }
    public Set<Restaurant> getAll(){
        return this.restaurants;
    }
}
