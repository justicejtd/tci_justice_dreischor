package tci.demo.week3.multipledocs;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

/**
 * mock all dependencies. even interfaces!
 */

public class MessengerTest {


        private static final String CLIENT_EMAIL = "some@email.com";
        private static final String MSG_CONTENT = "Dear John! You are fired.";

      /**
     * @verifies send email using mailserver when valid inputs are used.
     * @see Messenger#sendMessage(Client, Template)
     */
    @Test
    public void sendMessage_should_send_email_using_mailserver_when_valid_inputs_are_used() throws Exception {
        // arrange
        Template template = mock(Template.class);
        Client client = mock(Client.class);
        MailServer mailServer = mock(MailServer.class);
        TemplateEngine templateEngine = mock(TemplateEngine.class);
        Messenger sut = new Messenger(mailServer, templateEngine);
        when(client.getEmail()).thenReturn(CLIENT_EMAIL);
        when(templateEngine.prepareMessage(template, client)).thenReturn(MSG_CONTENT);
        // act
        sut.sendMessage(client, template);
        // assert
        verify(mailServer).send(CLIENT_EMAIL, MSG_CONTENT);
    }
}