package za.ac.cput.Factory;

import za.ac.cput.Domain.Activites.Sport;

public class SportFactory {
    public static Sport findSport(String sportName, String participant, int noParticipants, String hotelName){
        return new Sport.Builder().sportName(sportName).participant(participant).noPartic(noParticipants).hotelName(hotelName).build();
    }
}
