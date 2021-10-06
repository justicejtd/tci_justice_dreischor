package tci.demo.week4.legacycode.changingclass;

import java.util.Objects;

public class Zebra implements Animal {
    private final int numberOfStripes;

    public Zebra(int numberOfStripes) {
        this.numberOfStripes = numberOfStripes;
    }

    public int getNumberOfStripes() {
        return this.numberOfStripes;
    }


    //
    // add equals & hashcode checks: this allows LOGICAL comparison of Zebra objects
    //

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Zebra)) return false;
        Zebra zebra = (Zebra) o;
        return numberOfStripes == zebra.numberOfStripes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfStripes);
    }
}
