package tci.demo.week4.legacycode.extendingclass;

public class Zebra implements Animal {
    private final int numberOfStripes;

    public Zebra(int numberOfStripes) {
        this.numberOfStripes = numberOfStripes;
    }

    public int getNumberOfStripes() {
        return this.numberOfStripes;
    }


}
