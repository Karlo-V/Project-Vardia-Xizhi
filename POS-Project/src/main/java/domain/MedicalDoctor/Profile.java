package domain.MedicalDoctor;

import foundation.Assert;

public class Profile {

    private String avatarURL; // cant be null or blank
    private String firstName; // cant be null, max 255, can only contain characters (no number, no special symbols)
    private String lastName;// cant be null, max 255, can only contain characters (no number, no special symbols)

    private String bioGraphy;

    public Profile(String avatarURL, String bioGraphy, String firstName, String lastName) {
        setAvatarURL(avatarURL);
        setBioGraphy(bioGraphy);
        setFirstName(firstName);
        setLastName(lastName);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAvatarURL() {
        return avatarURL;
    }

    public String getBioGraphy() {
        return bioGraphy;
    }

    public void setFirstName(String firstName) {
        this.firstName = Assert.isNotNull(firstName, "Firstname");
        this.firstName = Assert.hasMaxLength(firstName, 255, "Firstname");
    }

    public void setLastName(String lastName) {
        this.firstName = Assert.isNotNull(firstName, "Lastname");
        this.firstName = Assert.hasMaxLength(firstName, 255, "lastname");
    }

    public void setAvatarURL(String avatarURL) {
        this.avatarURL = Assert.isNotBlank(avatarURL, "avatarURL");

    }

    public void setBioGraphy(String bioGraphy) {
        this.bioGraphy = bioGraphy;
    }

    public void ubdateAvatar(){


    }



}
