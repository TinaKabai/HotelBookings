package za.ac.cput.Domain.Content;

public class Restaurant {
    private String restuName;
    private int floor;
    private String menu;

    public Restaurant() {
    }

    private Restaurant(Builder builder){
        this.restuName = builder.restuName;
        this.floor = builder.floor;
        this.menu = builder.menu;
    }

    public String getRestuName() {
        return restuName;
    }

    public int getFloor() {
        return floor;
    }

    public String getMenu() {
        return menu;
    }
public static class Builder{
    private String restuName;
    private int floor;
    private String menu;

    public Builder restuname(String restuName){
        this.restuName = restuName;
        return this;
    }
    public Builder floor(int floor){
        this.floor = floor;
        return this;
    }
    public Builder menu(String menu){
        this.menu = menu;
        return this;
    }
    public Restaurant build(){
        return new Restaurant(this);
    }

    public Builder copy(Restaurant restaurant) {
        this.restuName = restaurant.restuName;
        this.floor = restaurant.floor;
        this.menu = restaurant.menu;

        return this;
    }
}
}
