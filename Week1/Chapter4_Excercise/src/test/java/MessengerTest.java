import org.junit.jupiter.api.Test;
import raceResultsService.models.*;

import static org.mockito.Mockito.*;

public class MessengerTest {

    @Test
    public void sendMessage_shouldExecutePrepareMessageCorrectly() {
        // Arrange DOCs
        MailServer mailServer = mock(MailServer.class);
        Client client = mock(Client.class);
        when(client.getEmail()).thenReturn("test@hotmail.com");
        Template template = mock(Template.class);
        TemplateEngine templateEngine = mock(TemplateEngine.class);
        when(templateEngine.prepareMessage(template, client)).thenReturn("msgContent");
        // Arrange
        Messenger messenger = new Messenger(mailServer, templateEngine);
        // Act
        messenger.sendMessage(client, template);
        // Verify
        verify(templateEngine).prepareMessage(template, client);
        verify(mailServer).send("test@hotmail.com", "msgContent");
    }
}