package raceResultsService.models;

import raceResultsService.interfaces.Client1;
import raceResultsService.interfaces.RaceCategory;

public class Subscriber implements raceResultsService.interfaces.Subscriber {

    private final Client1 client1;
    private final RaceCategory raceCategory;

    public Subscriber(Client1 client1, RaceCategory raceCategory) {
        this.client1 = client1;
        this.raceCategory = raceCategory;
    }

    @Override
    public Client1 getClient() {
        return client1;
    }

    @Override
    public RaceCategory getRaceCategory() {
        return raceCategory;
    }
}
