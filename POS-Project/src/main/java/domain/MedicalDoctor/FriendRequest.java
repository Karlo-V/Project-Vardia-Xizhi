package domain.MedicalDoctor;

import foundation.Assert;

import java.util.UUID;



import java.util.UUID;

public class FriendRequest {
    private UUID requestId; // id for every friendship request
    private User fromUser;  // sender of the request
    private User toUser;    // reciever of the request
    private RequestStatus status; // act. status of the request


    public enum RequestStatus { // 3 status
        PENDING,
        ACCEPTED,
        REJECTED
    }


    public FriendRequest(User fromUser, User toUser) {

        setFromUser(fromUser);
        setToUser(toUser);
        this.status = RequestStatus.PENDING;
        this.requestId = UUID.randomUUID();
    }

    public void acceptRequest() {
        this.status = RequestStatus.ACCEPTED;
        this.toUser.addFriend(this.fromUser);
        this.fromUser.addFriend(this.toUser);
    }

    public void rejectRequest() {
        this.status = RequestStatus.REJECTED;
    }


    public UUID getRequestId() {
        return requestId;
    }


    public User getFromUser() {
        return fromUser;
    }

    public User getToUser() {
        return toUser;
    }


    public RequestStatus getStatus() {
        return status;
    }


    public void setRequestId(UUID requestId) {
        this.requestId = requestId;
    }

    public void setFromUser(User fromUser) {
        this.fromUser = Assert.isNotNull(fromUser, "fromUser");
    }

    public void setToUser(User toUser) {
        this.toUser = Assert.isNotNull(toUser, "toUser");
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }
}