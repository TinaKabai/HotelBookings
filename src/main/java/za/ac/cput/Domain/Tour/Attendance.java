package za.ac.cput.Domain.Tour;

import za.ac.cput.Domain.Content.Guest;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Attendance extends Guest {

    @Id
    private boolean attending;

    public Attendance() {
    }

    private Attendance(Builder builder) {
        this.attending = builder.attending;
    }

    public boolean isAttending() {
        return attending;
    }

    public static class Builder{
        private boolean attending;

        public Builder attend(boolean attending){
            this.attending = attending;
            return this;
        }
        public Attendance build() {
            return new Attendance(this);
        }

        public Builder copy(Attendance attendance) {
            this.attending = attendance.attending;

            return this;
        }
    }
}
