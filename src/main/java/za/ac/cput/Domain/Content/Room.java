package za.ac.cput.Domain.Content;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Room {

    @Id
    private int roomNo;
    private String roomType;
    private String roomStatus;
    private int floor;
    private double price;

    public Room(){

    }

    private Room(Builder builder) {
        this.roomNo = builder.roomNo;
        this.roomType = builder.roomType;
        this.roomStatus = builder.roomStatus;
        this.floor = builder.floor;
        this.price = builder.price;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public String getRoomType() {
        return roomType;
    }

    public String getRoomStatus() {
        return roomStatus;
    }

    public int getFloor() {
        return floor;
    }

    public double getPrice() {
        return price;
    }

    public static class Builder{
    private int roomNo;
    private String roomType;
    private String roomStatus;
    private int floor;
    private double price;

    public Builder roomNo(int roomNo){
        this.roomNo = roomNo;
        return this;
    }
    public Builder roomType(String roomType){
        this.roomType = roomType;
        return this;
    }
    public Builder roomStatus(String roomStatus){
        this.roomStatus = roomStatus;
        return this;
    }
    public Builder floor(int floor){
        this.floor = floor;
        return this;
    }
    public Builder price(double price){
        this.price = price;
        return this;
    }
    public Room build() {
        return new Room(this);
    }

        public Builder copy(Room room) {
            this.roomNo = room.roomNo;
            this.roomType = room.roomType;
            this.roomStatus = room.roomStatus;
            this.floor = room.floor;
            this.price = room.price;

            return this;
        }
}
}
