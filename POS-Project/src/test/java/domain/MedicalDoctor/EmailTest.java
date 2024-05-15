package domain.MedicalDoctor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @Test
    void validateEmail_ShouldReturnTrue_IfLegalAddress() {
        try {
            //Given
            Email email = new Email("sss@qwe.at");

            //When
            boolean res = email.validateEmail();

            //Then
            assertTrue(res);
        } catch (MedicalDoctorException e) {
            fail("Exception should not be thrown for a valid email address");
        }
    }

    @Test
    void validateEmail_ShouldFail_IfIlLegalAddress() {
      try{
          // Given
          String illegalEmail = "chupapi.at";

          // When
          assertThrows(MedicalDoctorException.class, () -> {
          // Then
          new Email(illegalEmail);
          }, "Exception should be thrown for an invalid email address");

      }
         catch (MedicalDoctorException e) {
        fail();
    }
}

}