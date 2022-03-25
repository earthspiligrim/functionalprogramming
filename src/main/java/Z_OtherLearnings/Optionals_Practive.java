package Z_OtherLearnings;

import java.util.Optional;

public class Optionals_Practive {
    public static void main(String[] args) {
        Optional<Object> empty = Optional.empty();

        System.out.println("An object is empty or not");
        System.out.println(empty.isPresent());
        System.out.println(empty.isEmpty());

        System.out.println("An String object is empty or not");
        Optional<String> emptyString = Optional.empty();
        Optional<String> stringCheck = Optional.of("hello");
        System.out.println(stringCheck.isPresent());
        System.out.println(stringCheck.isEmpty());

        System.out.println(empty.isEmpty());

        String orElse = emptyString.orElse("world");
        System.out.println(orElse);

        /*
            Optional<T>.isEmpty() -- returns if the optional value is empty or not
            Optional<T>.isPresent() -- returns true if a value exists on the optional
            Optional<T>.isEmpty() -- returns true if the optional has empty value
            Optional<T>.orElse() -- can be used on an optional to use the alternative object, in the case of empty or null

         */

        //usage
        //Imperative approach
        String hello = null;
        String world;
        if(hello != null) world = hello;
        else world = "";

        //instead
        world = stringCheck.map(String::toUpperCase)
                .orElse("world");
        //or
        world = stringCheck.map(String::toUpperCase)
                .orElseGet(() -> {
                    return "world";
                });
        world = stringCheck.map(String::toUpperCase)
                .orElseThrow(IllegalStateException::new);

        stringCheck.ifPresent(System.out::println);
        //or
        stringCheck.ifPresent(word -> {
            System.out.println(word);
        });

        stringCheck.ifPresentOrElse(System.out::println, () -> System.out.println("else block"));
        //or
        stringCheck.ifPresentOrElse(word -> {
            //if part
            System.out.println(word);
        }, () -> {
            //else part
        });


    }
}
