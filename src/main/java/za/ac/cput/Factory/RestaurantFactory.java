package za.ac.cput.Factory;

import za.ac.cput.Domain.Content.Restaurant;

public class RestaurantFactory {
    public static Restaurant findRestaurant(String restName, int floor, String menu){
        return new Restaurant.Builder().restuname(restName).floor(floor).menu(menu).build();
    }
}
