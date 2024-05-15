package foundation;




import java.util.function.Supplier;

import static java.lang.StringTemplate.STR;


public abstract class Assert {


    // Null Assertions -------------------------------------------------------------

    // public static Object isNotNull(Object value, String paramName) {
    public static <T> T isNotNull(T value, String paramName) {
        if (value == null)
            throw new ApplicationException(STR."\{paramName} is null");

        return value;
    }


    // String Assertions -----------------------------------------------------------

    public static String isNotBlank(String value, String paramName) {
        isNotNull(value, paramName);

        if (value.isBlank())
            throw new ApplicationException(STR."\{paramName} is blank");

        return value;
    }
    public static <T> void isNotBlank2(T value, String paramName) {
        if (value == null || value.toString().isEmpty()) {
            throw new ApplicationException(paramName + " cannot be blank");
        }
    }



    public static void isTrue(boolean expression, Supplier<String> errorMsg) {
        if (!expression)
            throw new ApplicationException(errorMsg.get());
    }

    public static <T> T isEquals(T value, T check, String p){
        isNotNull(value,p);

        if(!value.equals(check)){
            throw new ApplicationException(STR."\{p} is not equals \{check}");
        }
        return value;
    }

    public static <T> T isNotEquals(T value, T check, String p){
        isNotNull(value,p);

        if(value.equals(check)){
            throw new ApplicationException(STR."\{p} is equals \{check}");
        }
        return value;
    }

    public static String hasMaxLength(String value, int maxLength, String paramName) {

        isNotBlank(value, paramName);

        if (value.length() > maxLength)
            throw new ApplicationException(STR."\{paramName} is greater than \{maxLength}");

        return value;
    }
    public static <T extends CharSequence> T hasMaxLength2(T value, int maxLength, String paramName) {
        isNotBlank2(value, paramName);

        int length = value.length();

        if (length > maxLength) {
            throw new ApplicationException(String.format("%s is greater than %d", paramName, maxLength));
        }

        return value;
    }





}
