package Topic7CombinatorPattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

import static Topic7CombinatorPattern.CustomerRegistrationValidatorUsingCombinationPattern.*;

public interface CustomerRegistrationValidatorUsingCombinationPattern
    extends Function<Customer, ValidationResult> {

    static CustomerRegistrationValidatorUsingCombinationPattern isEmailValid(){
        return customer -> customer.getEmail().contains("@") ?
                ValidationResult.SUCCESS : ValidationResult.EMAIL_NOT_VALID
                ;
    }

    static CustomerRegistrationValidatorUsingCombinationPattern isPhoneValid(){
        return customer -> customer.getPhoneNumber().length() == 10 ?
                ValidationResult.SUCCESS : ValidationResult.PHONE_NUMBER_NOT_VALID
                ;
    }

    static CustomerRegistrationValidatorUsingCombinationPattern isAdult(){
        return customer -> Period.between(customer.getDob(), LocalDate.now()).getYears() > 16 ?
                ValidationResult.SUCCESS : ValidationResult.IS_NOT_AN_ADULT
                ;
    }

    default CustomerRegistrationValidatorUsingCombinationPattern and (CustomerRegistrationValidatorUsingCombinationPattern other) {
        return customer -> {
            ValidationResult result = this.apply(customer);
            return result.equals(ValidationResult.SUCCESS) ? other.apply(customer) : result;
        };
    }

    enum ValidationResult{
        SUCCESS, PHONE_NUMBER_NOT_VALID,
        EMAIL_NOT_VALID,
        IS_NOT_AN_ADULT
    }
}
