package domain.Messenger;

import domain.MedicalDoctor.User;
import java.time.LocalDateTime;
import java.util.UUID;

public class Message {
    // not null
    private UUID messageId;
    // text of message, not null
    private String content;

    private LocalDateTime timestamp;
    // not null
    private User sender;


    // Constructor
    public Message(String content, User sender) {
        this.messageId = UUID.randomUUID();
        this.content = content;
        this.timestamp = LocalDateTime.now();
        this.sender = sender;
    }

    // Getters
    public UUID getMessageId() {
        return messageId;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public User getSender() {
        return sender;
    }

    // Setters (if needed)
    public void setContent(String content) {
        this.content = content;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }
}