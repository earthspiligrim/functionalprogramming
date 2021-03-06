package Topic7CombinatorPattern;

import java.time.LocalDate;
import Topic7CombinatorPattern.CustomerRegistrationValidatorUsingCombinationPattern.ValidationResult;

public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer("Alice", "alice@gmail.com", "9999999999", LocalDate.of(2000, 1, 1));

        System.out.println(new CustomerValidatorService().isValid(customer));

        /*
        Scenario Explanation: say you are calling isValid method which inturn calls some
        private methods and say if there is a mistake with phone number you dont know which
        exact is the mistake among which you are passing in

        Combinator Pattern: is a design pattern which can take functions as arguments and
        returns new functions.
         */
        //now using CombinatorPattern
        ValidationResult result = CustomerRegistrationValidatorUsingCombinationPattern
                .isEmailValid()
                .multipleValitions(CustomerRegistrationValidatorUsingCombinationPattern.isPhoneValid())
                .multipleValitions(CustomerRegistrationValidatorUsingCombinationPattern.isAdult())
                .apply(customer);
        System.out.println(result);
        if(result != ValidationResult.SUCCESS) throw new IllegalStateException(result.name());
    }
}
