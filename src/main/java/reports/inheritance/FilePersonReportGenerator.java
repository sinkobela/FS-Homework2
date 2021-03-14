package reports.inheritance;

import reports.Person;
import reports.inheritance.PersonReportGenerator;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FilePersonReportGenerator extends PersonReportGenerator {
    private final String file;

    public FilePersonReportGenerator(String file) {
        this.file = file;
    }

//    @Override
//    protected List<Person> readPersons() {
//        try {
//            Files.lines(Path.of(file))
//                    .map(this::readPerson)
//                    .collect(Collectors.toList());
//        } catch (IOException e) {
//            System.out.println("Cannot read from this file: " + file);
//        }
//        return List.of();
//    }

    @Override
    protected List<Person> readPersons() {
        try {
            List<Person> personList = new ArrayList<>();
            Scanner reader = new Scanner(new FileReader(file));
            while (reader.hasNextLine()) {
                personList.add(readPerson(reader.nextLine()));
            }
            return personList;
        } catch (IOException e) {
            System.out.println("Cannot read from this file: " + file);
        }
        return List.of();
    }

    private Person readPerson(String line) {
        String[] person = line.split(",");
        return new Person(person[0], person[1], Integer.parseInt(person[2]));
    }
}
