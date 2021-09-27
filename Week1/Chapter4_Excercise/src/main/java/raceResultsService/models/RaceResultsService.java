package raceResultsService.models;

import raceResultsService.interfaces.Client1;
import raceResultsService.interfaces.Message;
import raceResultsService.interfaces.RaceCategory;
import raceResultsService.models.Subscriber;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * It should allow subscribers to unsubscribe (which means they stop receiving messages),
 * Every time a new message comes, it should be sent to all subscribers.
 * * These simple requirements, along with some common sense, already furnish us with a lot of test cases.
 * * In the ensuing sections we will be implementing the following:
 * * • If multiple clients are subscribed, each of them should receive each incoming message,
 * * • Consecutive subscribe requests issued by the same client will be ignored (nothing happens),
 * * 4See http://en.wikipedia.org/wiki/Publish/subscribe.
 * * 74
 * * Chapter 5. Mocks, Stubs, and Dummies
 * * • If the client unsubscribes, then it should be the case that no more messages are sent to it.
 */

/**
 * raceResultsService.models.RaceResultsService should send messages with the results of different categories of race - e.g.
 * horse races, F1 races, boat-races, etc. Subscribers should be able to subscribe to selected categories.
 * Make sure they receive only messages related to the ones they have signed up for.
 */

public class RaceResultsService {
    public HashSet<Client1> clients = new HashSet<>();
    public HashSet<Message> messages = new HashSet<>();
    public final ArrayList<Subscriber> subscribers = new ArrayList<>();

    /**
     * @should not add already exiting subscribers
     * @param client1
     */
    public void addSubscriber(Client1 client1) {
        clients.add(client1);
    }

    /**
     * @should be able to subscribe to selected categories
     * @param client1
     * @param raceCategory
     */
    public void addSubscriber(Client1 client1, RaceCategory raceCategory) {
        subscribers.add(new Subscriber(client1, raceCategory));
    }

    /**
     * @param message
     * @should make sure that subscribed client received their message
     * @should not send message to not subscribed clients
     * @should not send already received message to client
     *
     */
    public void sendMessage(Message message) {
        for (Client1 c : clients) {
            if (!c.getMessages().contains(message)) {
                c.receive(message);
            }
        }
    }

    /**
     * @should not receive any messages when client is unsubscribed
     * @param client
     */
    public void removeSubscriber(Client1 client) {
        clients.remove(client);
    }

    /**
     * @should be able to send message with the results of different categories
     * @should only send messages to clients related to the race categories they have signed up for
     * @param raceCategory
     */
    public void sendMessage(RaceCategory raceCategory) {
        Message message = raceCategory.getResult();
        for (Subscriber s : subscribers) {
            if (s.getRaceCategory().getClass() == raceCategory.getClass()){
                s.getClient().receive(message);
            }
        }
    }
}
