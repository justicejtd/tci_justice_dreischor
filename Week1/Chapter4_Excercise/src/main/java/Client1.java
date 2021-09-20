import java.util.ArrayList;
import java.util.Collection;

public interface Client1 {
    ArrayList<Message> getMessages();

    void receive(Message message);
}
