package raceResultsService.interfaces;

import java.util.ArrayList;

public interface Client1 {
    ArrayList<Message> getMessages();

    void receive(Message message);
}
