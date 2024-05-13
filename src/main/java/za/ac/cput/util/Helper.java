package za.ac.cput.util;

import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.security.SecureRandom;
import java.util.regex.Pattern;

public class Helper
{
    public static boolean isNullOrEmpty(String s){
        if (s == null || s.isEmpty())
            return true;
        return false;
    }

    public static boolean isZeroOrLess(long num){
        if (num == 0 || num < 0)
            return true;
        return false;
    }

    public static Long generateId(){
        SecureRandom secureRandom = new SecureRandom();
        return Math.abs(secureRandom.nextLong());
    }

    public static boolean isValidEmail(String emailAddress) {
        String regexPattern = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }

    public static boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }

    public static Integer tryParse(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static boolean isDigitsOrIsTen(String s){
        if (tryParse(s) == null || s.length() != 10)
            return true;
        return false;
    }


}
