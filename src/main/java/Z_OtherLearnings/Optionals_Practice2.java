package Z_OtherLearnings;

import java.util.Locale;
import java.util.Optional;

public class Optionals_Practice2 {
    public static void main(String[] args) {

        Person p = new Person("gopi", "abcd@gmail.com");
        Person p2 = new Person("gopi", null);
        System.out.println(p.getEmail()); // this will print email but p2.getEmaail() will throw null pointer exception.
        /*
        so instead of having the getter of the email in person. when you know that email could be optional you should use Optional
        public Optional<String> getEmail(){
            return Optional.ofNullable(email);
        }
         */
        System.out.println(p2.getEmail().map(String::toUpperCase).orElse("email not provided"));
        //the above line due to the optional implementation will now not throw null pointer exception even if email is null

        // or

        if(p2.getEmail().isPresent()){
            String email = p2.getEmail().get();
            System.out.println(email.toLowerCase());
        } else System.out.println("email not provided");
    }

}
class Person {
    private final String name;
    private final String email;

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    /*
    public String getEmail() {
        return email;
    }

     */
    public Optional<String> getEmail(){
        return Optional.ofNullable(email);
    }
}
