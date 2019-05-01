package za.ac.cput.Factory;

import za.ac.cput.Domain.Content.Suite;

public class SuiteFactory {
    public static Suite suite(boolean suite){
        return new Suite.Builder().suite(suite).build();
    }
}
