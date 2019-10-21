package za.ac.cput.Domain.Content;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class NonAC extends Room {

    @Id
    private boolean nonAC;

    public NonAC() {
        super();
    }

    private NonAC(Builder builder) {

        this.nonAC = builder.nonAC;
    }

    public boolean isNonAC() {
        return nonAC;
    }

    public static class Builder {
        private boolean nonAC;

        public Builder nonAC(boolean nonAC) {
            this.nonAC = nonAC;
            return this;
        }

        public NonAC build() {
            return new NonAC(this);
        }

        public Builder copy(NonAC nonAC) {
            this.nonAC = nonAC.nonAC;

            return this;
        }
    }
}
