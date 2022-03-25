package Topic6JavaOptionals;

import java.util.Optional;
import java.util.function.Supplier;

public class _Optionals {
    public static void main(String[] args) {
        Object value = Optional.ofNullable(null)
                .orElseGet(() -> "default value");
        System.out.println(value);
        Object value2 = Optional.ofNullable("Hello")
                .orElseGet(() -> "default value");
        System.out.println(value2);

        Supplier<IllegalStateException> exception = () -> new IllegalStateException("exception");
        Object value3 = Optional.ofNullable("Hello")
                .orElseThrow(exception);
        System.out.println(value3);

        Optional.ofNullable("Hello")
                                .ifPresent(valueFromOptional -> {
                                    //do something with the value and do business logic
                                    System.out.println(valueFromOptional);
                                });
        //example
        Optional.ofNullable("joha@gmail.com")
                .ifPresent(email -> System.out.println("send email to " + email));

        Optional.ofNullable("joha@gmail.com")
                .ifPresentOrElse(
                        email -> System.out.println("THIS is if block: send email to " + email),
                        () -> System.out.println("THIS IS else block: Cannot send email")
                        );


    }
}
