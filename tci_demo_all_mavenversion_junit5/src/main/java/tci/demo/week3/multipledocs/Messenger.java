package tci.demo.week3.multipledocs;

public class Messenger {
    private TemplateEngine templateEngine;
    private MailServer mailServer;


    public Messenger(MailServer mailServer, TemplateEngine templateEngine){
        this.mailServer = mailServer;
        this.templateEngine = templateEngine;
    }

    /**
     * send message, which is prepared by the template, to the email address of the client.
     * @param client
     * @param template
     * @should send email using mailserver when valid inputs are used.
     * @should ????
     */
    public void sendMessage(Client client, Template template){
        String msgContent = templateEngine.prepareMessage(template, client);
        mailServer.send(client.getEmail(),msgContent);
    }
}
