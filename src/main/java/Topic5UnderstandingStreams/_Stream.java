package Topic5UnderstandingStreams;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import static Topic5UnderstandingStreams._Stream.Gender.Male;
import static Topic5UnderstandingStreams._Stream.Gender.Female;

public class _Stream {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", Male),
                new Person("Maria", Female),
                new Person("Isha", Female),
                new Person("Alex", Male),
                new Person("Alice", Female)
        );

        List<Boolean> listOfGendersInPeople = people.stream()
                .map(person -> person.gender.equals(Female))
                .collect(Collectors.toList());
        Set<Gender> genders = people.stream()
                                    .map(person -> person.gender)
                                    .collect(Collectors.toSet());

        people.stream()
                .map(person -> person.gender)
                .collect(Collectors.toList())
                .forEach(System.out::println);
        //equal to
        System.out.println("*************");
        people.stream()
                .map(person -> person.gender)
                .collect(Collectors.toSet())
                .forEach(gender -> System.out.println(gender));

        System.out.println("To print lenghts of the names in the people list");
        people.stream()
                .map(person -> person.name)
                .map(name -> name.length())
                .forEach(System.out::println);
        System.out.println("*********OR************");
        people.stream()
                .map(person -> person.name)
                .mapToInt(String::length)
                .forEach(System.out::println);

        System.out.println("*** understanding String::length and system.out::println");
        ToIntFunction<String> length = String::length;
        IntConsumer println = System.out::println;
        Function<Person, String> personStringFunction = person -> person.name;
        people.stream()
                .map(personStringFunction)
                .mapToInt(length)
                .forEach(println);

        /*
        Predicates all
        allMatch - returns true only if all persons in the people list are female
        anyMatch - returns true if atleast one validation goes right in this case atleast one person is female
        noneMatch - returns true only if there are no females in the list
         */
        System.out.println("Experimenting allMatch, anyMatch, noneMatch");
        Predicate<Person> checkIfFemale = person -> Female.equals(person.gender);
        boolean allMatchForFemales = people.stream()
                .allMatch(checkIfFemale);
        System.out.println(allMatchForFemales);

        boolean anyMatchForFemales = people.stream()
                .anyMatch(checkIfFemale);
        System.out.println(anyMatchForFemales);

        boolean noneMatchForFemale = people.stream()
                .noneMatch(checkIfFemale);
        System.out.println(noneMatchForFemale);
    }

    static class Person {

        private final String name;
        private final Gender gender;

        public Gender getGender() {
            return gender;
        }

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        Female, Male
    }
}
