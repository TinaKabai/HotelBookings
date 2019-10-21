package za.ac.cput.Domain.Content;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Suite extends Room {

    @Id
    private boolean suite;

    public Suite() {
        super();
    }

    private Suite(Builder builder) {

        this.suite = builder.suite;
    }

    public boolean isSuite() {
        return suite;
    }

    public static class Builder {
        private boolean suite;

        public Builder suite(boolean suite) {
            this.suite = suite;
            return this;
        }

        public Suite build() {
            return new Suite(this);
        }
        public Builder copy(Suite suite) {
            this.suite = suite.suite;

            return this;
        }
    }
}
