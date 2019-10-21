package za.ac.cput.Domain.Content;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Demographic {

    @Id
    private String race;
    private String culture;
    private int age;
    private String gender;

    public Demographic() {
    }
    private Demographic(Builder builder){
        this.race = builder.race;
        this.culture = builder.culture;
        this.age = builder.age;
        this.gender = builder.gender;
    }
    public String getRace() {
        return race;
    }

    public String getCulture() {
        return culture;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }
public static class Builder{
    private String race;
    private String culture;
    private int age;
    private String gender;

    public Builder race(String race){
        this.race = race;
        return this;
    }
    public Builder culture(String culture){
        this.culture = culture;
        return this;
    }
    public Builder age(int age){
        this.age = age;
        return this;
    }
    public Builder gender(String gender){
        this.gender = gender;
        return this;
    }
    public Demographic build(){
        return new Demographic(this);
    }

    public Builder copy(Demographic demographic) {
        this.race = demographic.race;
        this.culture = demographic.culture;
        this.age = demographic.age;
        this.gender = demographic.gender;

        return this;
    }
}
}
