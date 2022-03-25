package Topic3Predicate;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class _Predicate {

    /*
        Docs At: https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html
        Predicate<T> --> Represents a predicate(boolean-valued function) of one argument.
     */

    static Predicate<String> validatePhoneNumber = (phoneNumber) -> { return phoneNumber.startsWith("+91") && phoneNumber.length() == 13; };
    static Predicate<String> getValidatePhoneNumber2 = phoneNumber -> phoneNumber.startsWith("+91") && phoneNumber.length() == 13;

    static Predicate<String> contains3 = phoneNumber -> phoneNumber.contains("3");

    //BiPredicate
    static BiPredicate<String, Boolean> sampleBiPredicate = (phoneNumber, contains3) -> {
        return true;
    };

    //old way
    static boolean isPhoneNumberValid(String phoneNumber) {
        return  phoneNumber.startsWith("+91") && phoneNumber.length() == 13;
    }
    public static void main(String[] args) {
        //old way
        System.out.println(isPhoneNumberValid("+918888888888"));
        System.out.println(isPhoneNumberValid("+9188888888884"));
        System.out.println(validatePhoneNumber.test("+918888888888"));
        System.out.println(validatePhoneNumber.and(contains3).test("+9188888888884"));
        //using or
        System.out.println(validatePhoneNumber.or(contains3).test("+9188888888884"));

    }
}
