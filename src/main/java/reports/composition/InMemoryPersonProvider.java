package reports.composition;

import reports.Person;

import java.util.List;

public class InMemoryPersonProvider implements PersonProvider {

    @Override
    public List<Person> readPersons() {
        return List.of(
                new Person("Mack","Pinkham",54),
                new Person("Phyllis","Sensabaugh",63),
                new Person("Reena","Stach",12),
                new Person("Bernardina","Zucco",45),
                new Person("Vinita","Fielden",63),
                new Person("Shannan","Ragland",23),
                new Person("Chanel","Cypher",74),
                new Person("Cristine","Renfrew",21),
                new Person("Shari","Lennox",33));
    }
}
