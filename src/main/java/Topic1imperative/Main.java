package Topic1imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", Topic1imperative.Gender.Male),
                new Person("Maria", Topic1imperative.Gender.Female),
                new Person("Isha", Topic1imperative.Gender.Female),
                new Person("Alex", Topic1imperative.Gender.Male),
                new Person("Alice", Topic1imperative.Gender.Female)
        );

        //Lets find out how many feamales that we have
        //Imperative approach
        /*
        Approach 1 (Imperative Approach:)
         */
        System.out.println("Imperative Approach");
        List<Person> females = new ArrayList<>();

        for(Person person: people){
            if(Gender.Female.equals(person.getGender())) females.add(person);
        }

        for(Person female: females){
            System.out.println(female);
        }

        /*
        Approach 2: Declarative Approach for which we need to use the functional style of programming i.e streams with collections
        Stream: stream takes a list to an abstract mode where you could tell
         */
        System.out.println("Declarative Approach");
        System.out.println("****Declarative Approach where you could access the list elements within the stream and print it");
        people.stream()
                .filter(person -> Gender.Female.equals(person.getGender()))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        // or you can extract a list using strem and then print it like below

        System.out.println("****Declarative Approach where you extract a list and then print it");
        List<Person> females2 = people.stream()
                                .filter(person -> Gender.Female.equals(person.getGender()))
                                .collect(Collectors.toList());

        females2.forEach(System.out::println);

        /*
        Topic 2: Predicate: predicate is a functional interface which accepts an argument and returns a boolean, Usually
        it used to apply in a filter for a collection of objects.
        Telugu: predicate anedi oka anyonymus function lantidi adi oka object type meeda based out ayi edina logic perform cheyochu
        but return ga matram oka boolean istundi which can be used for filtering in example a list
         */

        Predicate<Person> genderFilterPredicate = person -> Topic1imperative.Gender.Female.equals(person.getGender());
        people.stream()
                .filter(genderFilterPredicate)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        BiPredicate<Person, String> testingBiPredicate = (person, gender) ->
                            Topic1imperative.Gender.Female.equals((person.getGender())) && person.getGender().equals("maria");
        System.out.println();



    }

    enum Gender { Male, Female}
}
