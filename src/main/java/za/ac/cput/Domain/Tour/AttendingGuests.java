package za.ac.cput.Domain.Tour;

public class AttendingGuests {
    private String guestName;
    private int age;

    public AttendingGuests() {
    }

    private AttendingGuests(Builder builder) {
        this.guestName = guestName;
        this.age = age;
    }

    public String getGuestName() {
        return guestName;
    }

    public int getAge() {
        return age;
    }

    public static class Builder{
        private String guestName;
        private int age;

        public Builder guestName(String guestName){
            this.guestName = guestName;
            return this;
        }
        public Builder age(int age){
            this.age = age;
            return this;
        }
        public AttendingGuests build() {
            return new AttendingGuests(this);
        }
    }
}
