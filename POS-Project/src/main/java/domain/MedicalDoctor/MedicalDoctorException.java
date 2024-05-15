package domain.MedicalDoctor;

public class MedicalDoctorException  extends RuntimeException{
    public MedicalDoctorException(String message) {
        super(message);
    }

    public MedicalDoctorException(String message, Throwable cause) {
        super(message, cause);
    }


}
