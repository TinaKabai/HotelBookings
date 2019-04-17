package za.ac.cput.Factory;

import za.ac.cput.Domain.Content.Restaurant;

public class RestaurantFactory {
    public static Restaurant findRestaurant(String restName, int restNo, String menu){
        return new Restaurant.Builder().restuname(restName).restaurantNo(restNo).menu(menu).build();
    }
}
