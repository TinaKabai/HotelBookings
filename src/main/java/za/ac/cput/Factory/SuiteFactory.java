package za.ac.cput.Factory;

import za.ac.cput.Domain.Content.Suite;

public class SuiteFactory {
    public static Suite suites(boolean suite){
        return new Suite.Builder().suite(suite).build();
    }
}
