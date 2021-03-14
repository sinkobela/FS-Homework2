package reports;

import java.util.Objects;

public class Person {
    private final String lastName;
    private final String firstName;
    private final int age;
    private final PersonAges interval;

    public Person(String lastName, String firstName, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.interval = setInterval(age);
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    public String getInterval() {
        return interval.getInterval();
    }

    private PersonAges setInterval(int age) {
        if (age <= 30) {
            return PersonAges.ONETOTHIRTY;
        } else if (age <= 50) {
            return PersonAges.THIRTYTOFIFTY;
        } else {
            return PersonAges.FIFTYPLUS;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(lastName, person.lastName) && Objects.equals(firstName, person.firstName) && interval == person.interval;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, age, interval);
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", age=" + age +
                ", interval=" + interval +
                '}';
    }
}
