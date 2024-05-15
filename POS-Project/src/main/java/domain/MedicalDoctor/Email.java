package domain.MedicalDoctor;

import foundation.Assert;

public class Email {

    private String emailAddress; // not null, correct format

    public Email(String emailAddress){
        setEmailAddress(emailAddress);

    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) throws MedicalDoctorException {
        this.emailAddress = emailAddress; // Set the email first
        if (!validateEmail()) { // Then validate
            throw new MedicalDoctorException("Illegal E-Mail Address");
        }
    }

    public boolean validateEmail() throws MedicalDoctorException {
        String email = getEmailAddress();

        if (email.startsWith(".") || email.startsWith("@")) {
            throw new MedicalDoctorException("Illegal E-Mail Address: It starts with '.' or '@'.");
        }

        int atPos = email.indexOf('@');
        int dotPos = email.lastIndexOf('.');

        if (atPos == -1 || dotPos == -1) {
            throw new MedicalDoctorException("Illegal E-Mail Address: Missing '@' or '.'.");
        }

        if (dotPos < atPos) {
            throw new MedicalDoctorException("Illegal E-Mail Address: '.' is before '@'.");
        }

        if (dotPos - atPos < 2) {
            throw new MedicalDoctorException("Illegal E-Mail Address: No character between '@' and '.'.");
        }

        if (dotPos + 1 >= email.length() || !Character.isLetter(email.charAt(dotPos + 1))) {
            throw new MedicalDoctorException("Illegal E-Mail Address: No letter after the last '.'.");
        }

        return true;
    }


}
