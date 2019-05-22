package za.ac.cput.Domain.Activites;

import za.ac.cput.Domain.Payment.Transaction;

public class Event implements Transaction {
    private String evName;
    private String hotelName;
    private String date;
    private double costs;

    public Event() {
    }
    private Event(Builder builder){
        this.evName = builder.evName;
        this.hotelName = builder.hotelName;
        this.date = builder.date;
        this.costs = builder.costs;

    }

    public String getEvName() {
        return evName;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getDate() {
        return date;
    }

    public double getCosts() {
        return costs;
    }

    public double pay() {
        return 0;
    }

    public static class Builder{
    private String evName;
    private String hotelName;
    private String date;
    private double costs;

    public Builder event(String evName){
        this.evName = evName;
        return this;
    }
    public Builder hotel(String hotelName){
        this.hotelName = hotelName;
        return this;
    }
    public Builder date(String date){
        this.date = date;
        return this;
    }
    public Builder cost(double costs){
        this.costs = costs;
        return this;
    }
    public Event build(){
        return new Event(this);
    }

        public Builder copy(Event event) {
            this.evName = event.evName;
            this.hotelName = event.hotelName;
            this.date = event.date;

            return this;
        }
}
}
