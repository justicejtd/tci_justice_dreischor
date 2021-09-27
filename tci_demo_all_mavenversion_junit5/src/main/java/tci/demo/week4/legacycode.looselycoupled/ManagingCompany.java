package tci.demo.week4.legacycode.looselycoupled;

public class ManagingCompany {

    private Zoo zoo;

    public ManagingCompany(Zoo zoo) {
        this.zoo = zoo;
    }

    /**
     * add a zebra to the zoo you are managing.
     */
    public void addZebra(Zebra zebra) {
        zoo.addAnimal(zebra);
    }
}
