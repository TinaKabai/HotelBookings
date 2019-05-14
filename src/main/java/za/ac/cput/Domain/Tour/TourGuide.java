package za.ac.cput.Domain.Tour;

public class TourGuide {
    private String name;
    private boolean availability;

    public TourGuide() {
    }

    private TourGuide(Builder builder) {
        this.name = name;
        this.availability = availability;
    }

    public String getName() {
        return name;
    }

    public boolean isAvailability() {
        return availability;
    }

    public static class Builder{
        private String name;
        private boolean availability;

        public Builder name(String name){
            this.name = name;
            return this;
        }
        public Builder available(boolean availability){
            this.availability = availability;
            return this;
        }
        public TourGuide build() {
            return new TourGuide(this);
        }
    }
}
