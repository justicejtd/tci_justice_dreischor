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

public class RaceResultsService {
    public HashSet<Client1> clients = new HashSet<>();

    /**
     * @should not add already exiting subscribers
     * @param client1
     */
    public void addSubscriber(Client1 client1) {
        clients.add(client1);
    }

    /**
     * @param message
     * @should make sure that subscribed client received their message
     * @should not send message to not subscribed clients
     * @should not send already received message to client
     */
    public void sendMessage(Message message) {
        for (Client1 c : clients) {
            c.receive(message);
        }
    }

    /**
     * @should not receive any messages when client is unsubscribed
     * @param client
     */
    public void removeSubscriber(Client1 client) {
        clients.remove(client);
    }
}
