public class Messenger {
    MailServer mailServer;
    TemplateEngine templateEngine;

    public Messenger(MailServer mailServer,
                     TemplateEngine templateEngine) {
        this.mailServer = mailServer;
        this.templateEngine = templateEngine;
    }

    /**
     * @should execute prepareMessage correctly
     * @should execute send method correctly
     * @param client
     * @param template
     */
    public void sendMessage(Client client, Template template) {
        String msgContent =
                templateEngine.prepareMessage(template, client);
        mailServer.send(client.getEmail(), msgContent);
    }
}

