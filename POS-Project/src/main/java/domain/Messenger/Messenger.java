package domain.Messenger;

import domain.MedicalDoctor.User;
import foundation.Assert;

import java.util.*;

public class Messenger {

    private UUID messengerId;   // not null
    private Set<User> participants;   // this set contains all contacts of a user. it can be null
    private List<Message> messages; // this list contains all messages in the conversation. list can be null, but message not


    public Messenger() {
        this.messengerId = UUID.randomUUID();
        this.participants = new HashSet<>();
        this.messages = new ArrayList<>();
    }


    public void sendMessage(Message message) {
        if (participants.contains(message.getSender())) {
            messages.add(message);
        } else {
            throw new IllegalArgumentException("Sender is not a participant in the messenger");
        }
    }

    public void addParticipant(User user) {
        participants.add(user);
    }

    public void removeParticipant(User user) {
        if (participants.contains(user)) {
            participants.remove(user);
        } else {
            throw new IllegalArgumentException("User is not a participant in the messenger");
        }
    }


    public UUID getMessengerId() {
        return messengerId;
    }

    public Set<User> getParticipants() {
        return participants;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessengerId(UUID messengerId) {
        this.messengerId = Assert.isNotNull(messengerId, "messengerIde");

    }

    public void setParticipants(Set<User> participants) {
        this.participants = participants;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}