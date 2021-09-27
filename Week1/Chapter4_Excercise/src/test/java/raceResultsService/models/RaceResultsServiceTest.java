package raceResultsService.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;
import raceResultsService.interfaces.Client1;
import raceResultsService.interfaces.Message;
import raceResultsService.interfaces.RaceCategory;
import raceResultsService.interfaces.categories.CatRace;
import raceResultsService.interfaces.categories.DogRace;
import raceResultsService.interfaces.categories.HorseRace;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class RaceResultsServiceTest {
    private final RaceResultsService raceResultsService = new RaceResultsService();
    private final Client1 client1 = mock(Client1.class);
    private final Client1 client2 = mock(Client1.class);
    private final Client1 client3 = mock(Client1.class);
    private final Message message = mock(Message.class);

    /**
     * @verifies make sure that subscribed client received message
     * @see RaceResultsService#sendMessage(Message)
     */
    @Test
    public void sendMessage_shouldMakeSureThatSubscribedClientReceivedTheirMessage() {
        // Act
        raceResultsService.addSubscriber(client1);
        raceResultsService.addSubscriber(client2);
        raceResultsService.addSubscriber(client3);
        raceResultsService.sendMessage(message);

        // Verify
        verify(client1).receive(message);
        verify(client2).receive(message);
        verify(client3).receive(message);
    }

    /**
     * @verifies not send message to unsubscribed clients
     * @see RaceResultsService#sendMessage(Message)
     */
    @Test
    public void sendMessage_shouldNotSendMessageToNotSubscribedClients() {
        // Act
        raceResultsService.sendMessage(message);

        // Verify
        verify(client1, never()).receive(message);
        verify(client2, never()).receive(message);
        verify(client3, never()).receive(message);
    }

    /**
     * @verifies not send already received message to client
     * @see RaceResultsService#sendMessage(Message)
     */
    @Test
    public void sendMessage_shouldNotSendAlreadyReceivedMessageToClient() {
        // Arrange
        ArrayList<Message> messages = new ArrayList<>();
        // Act
        messages.add(message);
        when(client1.getMessages()).thenReturn(messages);
        raceResultsService.addSubscriber(client1);
        raceResultsService.sendMessage(message);

        // Verify
        verify(client1, never()).receive(message);
    }

    /**
     * @verifies not add already exiting subscribers
     * @see RaceResultsService#addSubscriber(Client1)
     */
    @Test
    public void addSubscriber_shouldNotAddAlreadyExitingSubscribers() {
        // Arrange
        ArrayList<Message> messages = new ArrayList<>();
        messages.add(message);
        messages.add(mock(Message.class));
        messages.add(mock(Message.class));
        // Act
        raceResultsService.addSubscriber(client1);
        raceResultsService.addSubscriber(client1);
        raceResultsService.sendMessage(message);

        // Verify
        verify(client1).receive(message);
    }

    /**
     * @verifies not receive any messages when client is unsubscribed
     * @see RaceResultsService#removeSubscriber(Client1)
     */
    @Test
    public void removeSubscriber_shouldNotReceiveAnyMessagesWhenClientIsUnsubscribed() {
        // Act
        raceResultsService.addSubscriber(client1);
        raceResultsService.addSubscriber(client2);
        raceResultsService.removeSubscriber(client1);
        raceResultsService.sendMessage(message);
        // Verify
        verify(client1, never()).receive(message);
    }

    /**
     * @verifies be able to send message with the results of different categories
     * @see RaceResultsService#sendMessage(raceResultsService.interfaces.RaceCategory)
     */
    @Test
    public void sendMessage_shouldBeAbleToSendMessageWithTheResultsOfDifferentCategories() {
        // Arrange
        HorseRace horseRace = mock(HorseRace.class);
        // Act
        when(horseRace.getResult()).thenReturn(message);
        raceResultsService.addSubscriber(client1, horseRace);
        raceResultsService.sendMessage(horseRace);
        // Verify
        verify(client1).receive(message);
    }

    /**
     * @verifies be able to subscribe to selected categories
     * @see RaceResultsService#addSubscriber(Client1, RaceCategory)
     */
    @Test
    public void addSubscriber_shouldBeAbleToSubscribeToSelectedCategories() {
        // Arrange
        HorseRace horseRace = mock(HorseRace.class);
        // Act
        raceResultsService.addSubscriber(client1, horseRace);
        // Assert
        assertThat(raceResultsService.subscribers.size()).isEqualTo(1);

    }

    /**
     * @verifies only send messages to clients related to the race categories they have signed up for
     * @see RaceResultsService#sendMessage(RaceCategory)
     */
    @Test
    public void sendMessage_shouldOnlySendMessagesToClientsRelatedToTheRaceCategoriesTheyHaveSignedUpFor() {
        // Arrange
        CatRace catRace = mock(CatRace.class);
        DogRace dogRace = mock(DogRace.class);
        HorseRace horseRace = mock(HorseRace.class);
        Subscriber subscriberA = mock(Subscriber.class);
        Subscriber subscriberB = mock(Subscriber.class);
        Subscriber subscriberC = mock(Subscriber.class);
        // Act
        when(catRace.getResult()).thenReturn(message);
        when(dogRace.getResult()).thenReturn(message);
        when(horseRace.getResult()).thenReturn(message);
        when(subscriberA.getClient()).thenReturn(client1);
        when(subscriberA.getRaceCategory()).thenReturn(catRace);
        when(subscriberB.getRaceCategory()).thenReturn(dogRace);
        when(subscriberC.getRaceCategory()).thenReturn(horseRace);
        raceResultsService.subscribers.add(subscriberA);
        raceResultsService.subscribers.add(subscriberB);
        raceResultsService.subscribers.add(subscriberC);

        raceResultsService.sendMessage(catRace);
        // Verify
        verify(client1).receive(message);
        verify(client2, never()).receive(message);
        verify(client3, never()).receive(message);
    }
}