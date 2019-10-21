package za.ac.cput.Service.Content.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Content.Restaurant;
import za.ac.cput.Repository.content.RestaurantRepository;
import za.ac.cput.Service.Content.RestaurantService;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private static RestaurantService service = null;

    @Autowired
    private RestaurantRepository repo;

    private RestaurantServiceImpl(){

    }

    public static RestaurantService getService()
    {
        if(service == null) service = new RestaurantServiceImpl();
        return service;
    }

    @Override
    public Restaurant retrieveById(String id)
    {
        List<Restaurant> restaurants = getAll();
        for(Restaurant r: restaurants)
        {
            if (r.getRestuName().equals(id)) return r;
        }
        return null;
    }

    @Override
    public List<Restaurant> getAll() {
        return this.repo.findAll();
    }

    public Restaurant create(Restaurant restaurant) {
        return this.repo.save(restaurant);
    }


    public Restaurant read(String s) {
        return this.repo.findById(s).orElse(null);
    }


    public Restaurant update(Restaurant restaurant) {
        return this.repo.save(restaurant);
    }

    @Override
    public void delete(String s) {
        this.repo.deleteById(s);
    }
}
