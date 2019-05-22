package za.ac.cput.Domain.Tour;

public class TourGuide {
    private String name;
    private boolean available;

    public TourGuide() {
    }

    private TourGuide(Builder builder) {
        this.name = builder.name;
        this.available = builder.available;
    }

    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        return available;
    }

    public static class Builder{
        private String name;
        private boolean available;

        public Builder name(String name){
            this.name = name;
            return this;
        }
        public Builder availability(boolean available){
            this.available = available;
            return this;
        }
        public TourGuide build() {
            return new TourGuide(this);
        }

        public Builder copy(TourGuide tourGuide) {
            this.name = tourGuide.name;
            this.available = tourGuide.available;

            return this;
        }
    }
}
