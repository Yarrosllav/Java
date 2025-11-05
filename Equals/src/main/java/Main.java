import java.util.Objects;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class Main {

    public static void main(String[] args) {

        Person original = new Person("Will", "Smith", 19);

        System.out.println("Person to convert: " + original);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(original);

        System.out.println(json);

        Person person = gson.fromJson(json, Person.class);

        System.out.println("Converted person: " + person);

        System.out.println("\nOriginal and converted are equal: " + original.equals(person));

    }
}
class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(){

    }

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(firstName, person.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}