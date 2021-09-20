import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.verification.VerificationMode;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.ARRAY;
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
        messages.add(message);
        messages.add(mock(Message.class));
        messages.add(mock(Message.class));
        // Act
        //when(client1.getMessages()).thenReturn(messages);
        raceResultsService.addSubscriber(client1);
        raceResultsService.sendMessage(message);
        raceResultsService.sendMessage(message);

        //raceResultsService.sendMessage(message);

        // Verify
        verify(client1).receive(message);
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
}