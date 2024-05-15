package domain.MedicalDoctor;

import domain.BaseEntity;
import foundation.Assert;

import java.util.Set;
import java.util.UUID;
import java.util.HashMap;
public class User extends BaseEntity {
    private UUID ID;
    // ID of User, can not be null  and can not be changed after the setting
    private String username;
    // nickname, can noy be null and empty string
    private Email email;
    // account or login, can not be null and its format must be check in class Email
    private Password password;
    // not null, strength must be tested
    private Profile userProfile;
    // more infos about the user, not null
    private int score;
    // score for solve a case, standard 0, should not be a negative value
    private Set<User> friends;
    // this set contains the lists of user's firends, elements must be a user,
    //set cant be null, but empty is allowed, user cant be null
    private HashMap<UUID, FriendRequest> incomingRequests;
    // contains the recieved reques
    private HashMap<UUID, FriendRequest> outgoingRequests;
    // contains  the sended reques of user




    public User(UUID ID, String username, Email email, Password password, Profile userProfile, Set<User> friends, int score) {
        setID(ID);
        setUsername(username);
        setEmail(email);
        setPassword(password);
        setUserProfile(userProfile);
        setFriends(friends);
        setScore(score);
        this.incomingRequests = new HashMap<>();
        this.outgoingRequests = new HashMap<>();
    }

    public UUID getID() {
        return ID;
    }
    public String getUsername() {
        return username;
    }

    public Email getEmail() {
        return email;
    }

    public Password getPassword() {
        return password;
    }

    public Profile getUserProfile() {
        return userProfile;
    }

    public Set<User> getFriends() {
        return friends;
    }

    public int getScore() {
        return score;
    }

    public void setID(UUID ID) {

        this.ID = Assert.isNotNull(ID, "ID");
        this.ID = UUID.randomUUID();
    }

    public void setUsername(String username) {
        this.username = Assert.isNotNull(username, "Username");
        this.username = Assert.hasMaxLength(username, 255, "Username");

    }

    public void setEmail(Email email) {
        this.email = Assert.isNotNull(email, "Email");
    }

    public void setPassword(Password password) {

        this.password = Assert.isNotNull(password, "Password");
    }

    public void setUserProfile(Profile userProfile) {

        this.userProfile =  Assert.isNotNull(userProfile, "UserProfile");
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }

    public void setScore(int score) {
        this.score = score;
    }


    public void updateProfile(Profile newprofile) {

        this.userProfile =  newprofile;
    }

    public void addFriend(User friend) {

        this.friends.add(friend);
    }
    public void removeFriend(User friend){
        friends.remove(friend);

    }
    // 更新积分
    public void updateScore(int points) {

        this.score += points;

    }



}
