package reports.inheritance;

import reports.Person;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

abstract class PersonReportGenerator {

    public void generateReport(String output) throws IOException {
        List<Person> personList = readPersons();
        writeReport(personList,output);
    }

    private void writeReport(List<Person> personList, String output) throws IOException {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(output))) {
            writer.write("1 - 30: ");
            filterPersonsByAge(personList, "1-30").stream()
                    .map(person -> person.getLastName() + " " + person.getFirstName() + ", " )
                    .forEach(line -> writeLine(writer, line));

            writer.newLine();
            writer.write("30 - 50: ");
            filterPersonsByAge(personList, "30-50").stream()
                    .map(person -> person.getLastName() + " " + person.getFirstName() + ", " )
                    .forEach(line -> writeLine(writer, line));

            writer.newLine();
            writer.write("50+ : ");
            filterPersonsByAge(personList, "50+").stream()
                    .map(person -> person.getLastName() + " " + person.getFirstName() + ", " )
                    .forEach(line -> writeLine(writer, line));

        }
    }

    private void writeLine(BufferedWriter writer, String line) {
        try {
            writer.write(line);
//            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Person> groupPersonsByAge(List<Person> personList) {
        return personList
                .stream()
                .sorted(Comparator.comparing(Person::getInterval))
                .collect(Collectors.toList());
    }

    private List<Person> filterPersonsByAge(List<Person> personList, String age) {
        return personList
                .stream()
                .filter(person -> person.getInterval().equals(age))
                .collect(Collectors.toList());
    }



    protected abstract List<Person> readPersons();
}
