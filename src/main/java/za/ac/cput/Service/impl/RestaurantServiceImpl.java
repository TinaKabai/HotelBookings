package za.ac.cput.Service.impl;

import za.ac.cput.Domain.Content.Restaurant;
import za.ac.cput.Repository.Implementation.RestaurantRepositoryImpl;
import za.ac.cput.Repository.RestaurantRepository;
import za.ac.cput.Service.RestaurantService;

import java.util.Set;

public class RestaurantServiceImpl implements RestaurantService {

    private RestaurantServiceImpl service = null;
    private RestaurantRepository repository;

    private RestaurantServiceImpl(){
        this.repository = RestaurantRepositoryImpl.getRepository();
    }

    public RestaurantServiceImpl getService(){
        if (service == null) service = new RestaurantServiceImpl();
        return null;
    }

    @Override
    public Restaurant create(Restaurant restaurant) {
        return this.repository.create(restaurant);
    }

    @Override
    public Restaurant update(Restaurant restaurant) {
        return this.repository.update(restaurant);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Restaurant read(String s) {
        return this.repository.read(s);
    }

    public Set<Restaurant> getAll() {
        return this.repository.getAll();
    }
}
