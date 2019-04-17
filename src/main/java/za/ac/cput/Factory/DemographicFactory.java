package za.ac.cput.Factory;

import za.ac.cput.Domain.Content.Demographic;

public class DemographicFactory {
    public static Demographic identifyDemo(String race, String culture, int age, String gender){
        return new Demographic.Builder().race(race).culture(culture).age(age).build();
    }
}
