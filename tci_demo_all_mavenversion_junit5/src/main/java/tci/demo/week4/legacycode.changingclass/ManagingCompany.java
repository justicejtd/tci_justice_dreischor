package tci.demo.week4.legacycode.changingclass;

public class ManagingCompany {

    private Zoo zoo;

    public ManagingCompany(Zoo zoo) {
        this.zoo = zoo;
    }

    /**
     * add a zebra with given number of stripes to the zoo.
     * @param numberOfStripes
     */
    public void addZebra(int numberOfStripes) {
        Zebra zebra = new Zebra(numberOfStripes);
        zoo.addAnimal(zebra);
    }
}
