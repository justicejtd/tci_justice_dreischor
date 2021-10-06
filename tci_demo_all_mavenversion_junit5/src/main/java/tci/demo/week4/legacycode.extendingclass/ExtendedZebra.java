package tci.demo.week4.legacycode.extendingclass;

import java.util.Objects;

public class ExtendedZebra extends Zebra {

    public ExtendedZebra(int numberOfStripes) {
        super(numberOfStripes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.getNumberOfStripes());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Zebra)) return false;
        Zebra zebra = (Zebra) o;
        return super.getNumberOfStripes() == zebra.getNumberOfStripes();
    }


}
