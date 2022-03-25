package Topic7CombinatorPattern;

import java.time.LocalDate;
import java.time.Period;

public class CustomerValidatorService {

    private boolean isEmailValid(String email){
        return email.contains("@");
    }

    private boolean isPhoneValid(String phone){
        return phone.length() == 10;
    }

    private boolean isAdult(LocalDate dob){
        return Period.between(dob, LocalDate.now()).getYears() > 16;
    }

    public boolean isValid(Customer c){
        return isEmailValid(c.getEmail())
                && isPhoneValid(c.getPhoneNumber())
                && isAdult(c.getDob());
    }
}
