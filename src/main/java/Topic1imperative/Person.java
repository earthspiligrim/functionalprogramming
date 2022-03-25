package Topic1imperative;

public class Person {

    private String name;
    private Gender gender;

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
