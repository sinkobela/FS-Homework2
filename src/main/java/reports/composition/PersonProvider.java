package reports.composition;

import reports.Person;

import java.util.List;

public interface PersonProvider {
    List<Person> readPersons();
}
