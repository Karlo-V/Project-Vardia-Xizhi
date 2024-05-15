package domain.MedicalCasse;

import domain.Messenger.Message;
import domain.MedicalDoctor.User;
import java.util.*;

public class Discussion {


    private UUID discussionId; // Unique ID for a discussion, not null
    private MedicalCase medicalCase;// not null
    private List<Message> messages;// List of all messages in the discussion(ChatHistory), the list can be null, but message cant be null


    public Discussion(MedicalCase medicalCase) {
        this.discussionId = UUID.randomUUID();
        this.medicalCase = medicalCase;
        this.messages = new ArrayList<>();
    }

    public UUID getDiscussionId() {
        return discussionId;
    }

    public MedicalCase getMedicalCase() {
        return medicalCase;
    }


    public List<Message> getMessages() {
        return messages;
    }


    public void setMedicalCase(MedicalCase medicalCase) {
        this.medicalCase = medicalCase;
    }


    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }


    public void postMessage(User user, String content) {
        if (medicalCase.isMember(user)) {
            Message newMessage = new Message(content,user );
            messages.add(newMessage);
            System.out.println("Message posted by " + user.getUsername() + ": " + content);
        } else {
            System.out.println("User " + user.getUsername() + " is not a member and cannot post messages.");
        }
    }

}