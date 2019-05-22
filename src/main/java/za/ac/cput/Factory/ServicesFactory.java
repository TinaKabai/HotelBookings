package za.ac.cput.Factory;

import za.ac.cput.Domain.Content.Services;

public class ServicesFactory {
    public static Services chooseService(String name, String desc, double price){
        return new Services.Builder().sName(name).description(desc).price(price).build();
    }
}
