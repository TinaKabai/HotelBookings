package za.ac.cput.Domain.Content;

public class Deluxe extends Room {

    private boolean deluxe;

    public Deluxe() {
        super();
    }

    private Deluxe(Builder builder) {

        this.deluxe = builder.deluxe;
    }

    public boolean isDeluxe() {
        return deluxe;
    }

    public static class Builder {
        private boolean deluxe;

        public Builder deluxe(boolean deluxe) {
            this.deluxe = deluxe;
            return this;
        }

        public Deluxe build() {
            return new Deluxe(this);
        }

        public Builder copy(Deluxe deluxe) {
            this.deluxe = deluxe.deluxe;

            return this;
        }
    }
}
