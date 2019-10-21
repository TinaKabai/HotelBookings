package za.ac.cput.Domain.Activites;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Sport {

    @Id
    private String sportName;
    private String participant;
    private int noParticipants;
    private String hotelName;

    public Sport() {
    }
    private Sport(Builder builder){
        this.sportName = builder.sportName;
        this.participant = builder.participant;
        this.noParticipants = builder.noParticipants;
        this.hotelName = builder.hotelName;

    }
    public String getSportName() {
        return sportName;
    }

    public String getParticipant() {
        return participant;
    }

    public int getNoParticipants() {
        return noParticipants;
    }

    public String getHotelName() {
        return hotelName;
    }

    public static class Builder {
        private String sportName;
        private String participant;
        private int noParticipants;
        private String hotelName;

        public Builder sportName(String sportName) {
            this.sportName = sportName;
            return this;
        }
        public Builder participant(String participant) {
            this.participant = participant;
            return this;
        }
        public Builder noPartic(int noParticipants) {
            this.noParticipants = noParticipants;
            return this;
        }
        public Builder hotelName(String hotelName) {
            this.hotelName = hotelName;
            return this;
        }
        public Sport build(){
            return new Sport(this);
        }

        public Builder copy(Sport sport) {
            this.sportName = sport.sportName;
            this.participant = sport.participant;
            this.noParticipants = sport.noParticipants;
            this.hotelName = sport.hotelName;

            return this;
        }
    }

}
