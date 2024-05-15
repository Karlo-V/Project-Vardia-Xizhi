package domain.MedicalDoctor;

import org.mindrot.jbcrypt.BCrypt;
import com.nulabinc.zxcvbn.Strength;
import com.nulabinc.zxcvbn.Zxcvbn;

// das ist von chat gpt, wir werden versuchen es zu verstehen in den naechsten wochen
public class Password {

    // Das gehashte Passwort
    private String hashedPassword;

    // Länge des Passworts
    private int length;

    // Konstruktor zur Initialisierung des gehashten Passworts und der Länge
    public Password(String hashedPassword, int length) {
        this.hashedPassword = hashedPassword;
        this.length = length;  // Die Länge wird hier korrekt auf den übergebenen Wert gesetzt
    }


    public void createPassword(Password password) {

    }

}