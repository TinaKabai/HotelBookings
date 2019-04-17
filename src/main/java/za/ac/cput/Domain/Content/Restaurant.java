package za.ac.cput.Domain.Content;

public class Restaurant {
    private String restuName;
    private int noRestaurants;
    private String menu;

    public Restaurant() {
    }

    private Restaurant(Builder builder){
        this.restuName = builder.restuName;
        this.noRestaurants = builder.noRestaurants;
        this.menu = builder.menu;
    }

    public String getRestuName() {
        return restuName;
    }

    public int getNoResturants() {
        return noRestaurants;
    }

    public String getMenu() {
        return menu;
    }
public static class Builder{
    private String restuName;
    private int noRestaurants;
    private String menu;

    public Builder restuname(String restuName){
        this.restuName = restuName;
        return this;
    }
    public Builder restaurantNo(int noRestaurants){
        this.noRestaurants = noRestaurants;
        return this;
    }
    public Builder menu(String menu){
        this.menu = menu;
        return this;
    }
    public Restaurant build(){
        return new Restaurant(this);
    }
}
}
