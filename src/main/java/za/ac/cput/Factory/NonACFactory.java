package za.ac.cput.Factory;

import za.ac.cput.Domain.Content.NonAC;
import za.ac.cput.Domain.Content.Room;

public class NonACFactory {
    public static NonAC accessibility(boolean nonAC){
        return new NonAC.Builder().nonAC(nonAC).build();
    }
}
