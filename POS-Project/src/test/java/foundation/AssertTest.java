package foundation;

import static org.junit.jupiter.api.Assertions.*;

import foundation.ApplicationException;
import foundation.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AssertTest {


    @Test
    public void testIsNotNull_WithNonNullString() {
        try{
            String paramName = "testString";
            String value = "Hello";

            String result = Assert.isNotNull(value, paramName);

            assertEquals(value, result);
        }catch (ApplicationException e)
        {
            assertThrows(ApplicationException.class, () ->  Assert.isNotNull("Hello","paraname"));
        }
    }
    @Test
    public void testIsNotNull_WithNonNullInteger() {

        String paramName = "testInteger";
        Integer value = 123;

        Integer result = Assert.isNotNull(value, paramName);

        assertEquals(value, result);
    }

    @Test
    void testIsNotBlank_WithNonBlankString(){
        try
        {
            String paramName = "testString";
            String value = "Hello";


            String result = Assert.isNotBlank(value, paramName);


            assertEquals(value, result);
        } catch (ApplicationException e)
        {
            assertThrows(ApplicationException.class, () ->  Assert.isNotBlank("Hello","paraname"));
        }

    }



    @Test
    public void testIsNotBlank_WithBlankString() {
        // Arrange
        String paramName = "testString";
        String value = "   ";

        // Act
        Assert.isNotBlank(value, paramName);

        // Assert is handled by the expected exception
    }

    @Test
    public void testIsNotBlank_WithEmptyString() {
        // Arrange
        String paramName = "testString";
        String value = "";

        // Act
        Assert.isNotBlank(value, paramName);

        // Assert is handled by the expected exception
    }

    @Test
    public void testIsNotBlank_WithNullString() {
        // Arrange
        String paramName = "testString";

        // Act
        Assert.isNotBlank(null, paramName);

        // Assert is handled by the expected exception
    }

    @Test
    void testhasMaxlenth(){

        try{
            String pareName = "TestString" ;

            Assert.hasMaxLength("aaaaaa",6,pareName);

        } catch (ApplicationException e){

            fail();
        }


    }
    @Test
    public void testIsEqualsWithEqualValues() {
       //g
        String value = "test";
        String check = "test";
        String param = "Value";
       //w
        String result = Assert.isEquals(value, check, param);
       //t
        Assertions.assertSame(value, result);
    }

    @Test
    public void isNotEquals_ShouldWork() {
        try {

            String paramName = "testValue";
        Integer value = 123;
        Integer check = 456;


            Integer result = Assert.isNotEquals(value, check, paramName);
            Assertions.assertEquals(value, result);
        } catch (ApplicationException e) {
        fail();
        }
    }
    @Test
    public void isNotEquals_ShouldFailWhenEquals() {
        try {
        String paramName = "testValue";
        Integer value = 123;
        Integer check = 123;

        Assertions.assertThrows(ApplicationException.class, () -> {
            Assert.isNotEquals(value, check, paramName);
        });
    } catch (ApplicationException e){
        fail();
        }
    }

    @Test
    public void testHasMaxLength2_ValidInput_ShouldWork() {
        String input = "Hello";
        String result = Assert.hasMaxLength2(input, 10, "testParam");
        assertEquals(input, result, "return the original value when <= max length");
    }
    @Test
    public void testHasMaxLength2_InValidInput_ShouldntWork() {
        String input = "This is too long";
        Exception exception = assertThrows(ApplicationException.class, () -> {
            Assert.hasMaxLength2(input, 10, "testParam");
        });
        assertTrue(exception.getMessage().contains("testParam is bigger than 10"));
    }

}









